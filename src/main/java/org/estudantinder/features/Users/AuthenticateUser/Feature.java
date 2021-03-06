package org.estudantinder.features.Users.AuthenticateUser;

import java.security.spec.InvalidKeySpecException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import org.estudantinder.entities.Users;
import org.estudantinder.features.Users.AuthenticateUser.DTO.JwtDTO;
import org.estudantinder.features.Users.AuthenticateUser.DTO.LoginDTO;
import org.estudantinder.repositories.UsersRepository;
import org.wildfly.security.credential.PasswordCredential;
import org.wildfly.security.evidence.PasswordGuessEvidence;
import org.wildfly.security.password.util.ModularCrypt;

import io.quarkus.security.UnauthorizedException;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class Feature {

    @Inject
    UsersRepository usersRepository;

    public boolean isPasswordCorrect(String hashDBPassword, String loginPassword) throws InvalidKeySpecException {
        PasswordCredential producedPasswordCredential = new PasswordCredential(ModularCrypt.decode(hashDBPassword));
        PasswordGuessEvidence correctPasswordEvidence = new PasswordGuessEvidence(loginPassword.toCharArray());
        return (producedPasswordCredential.verify(correctPasswordEvidence));
    }

    public JwtDTO execute(LoginDTO data) throws Exception {
        Users authenticatedUser =  usersRepository.findByEmail(data.email);

        Instant expireDate = Instant.now().plus(15, ChronoUnit.DAYS);

        if(authenticatedUser == null) {
            throw new NotFoundException("Email Not Found");
        }
        if(!isPasswordCorrect(authenticatedUser.getPassword(), data.password)) {
            throw new UnauthorizedException("Wrong Password");
        }

        String token = Jwt.issuer("https://github.com/AdamAugustinsky")
            .upn("estudantinder@quarkus.io")
            .groups("User")
            .claim("id", authenticatedUser.getId())
            .expiresAt(expireDate)
            .sign();
        
        JwtDTO returnObject = new JwtDTO();

        returnObject.jwt = token;
        returnObject.expireDate = expireDate;

        return returnObject;
    }
}
