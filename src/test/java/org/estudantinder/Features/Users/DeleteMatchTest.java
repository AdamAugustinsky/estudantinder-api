package org.estudantinder.Features.Users;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.jwt.build.Jwt;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@QuarkusTest
public class DeleteMatchTest {

    @Test
    public void testDeleteMatchEndpoint() {
        given()
        .auth().oauth2(generateValidStudentToken())
        .pathParam("id", 28)
        .when().delete("/users/matchs/{id}")
        .then()
            .statusCode(200);
    }

    static String generateValidStudentToken() {
        return Jwt.issuer("https://github.com/AdamAugustinsky")
            .upn("estudantinder@quarkus.io")
            .groups("Student")
            .claim("id", 21)
            .expiresAt(Instant.now().plus(2, ChronoUnit.MINUTES ))
            .sign();
    }
}