package org.estudantinder.features.Students.Matchs.ShowMatchs;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.estudantinder.features.Students.common.MatchReturn;
import org.estudantinder.features.commom.ErrorMessage;

@ApplicationScoped
public class Controller {

    @Inject
    Feature showStudentMatchs;

    public Response handle(JsonWebToken jwt) throws Exception {
        try {
            List<MatchReturn> StudentMatchs = showStudentMatchs.execute(jwt);

            return Response
                .status(Response.Status.OK)
                .entity(StudentMatchs)
                .build();
                
        } catch (NotFoundException error) {
            ErrorMessage errorMessage = new ErrorMessage();
            
            errorMessage.error = error.getMessage();
            errorMessage.message = "Couldn't show Student Matchs";

            return Response
                .status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
        } catch(Exception error) {
            ErrorMessage errorMessage = new ErrorMessage();
            
            errorMessage.error = error.getMessage();
            errorMessage.message = "Couldn't show Student Matchs";

            return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .build();
        }
    }
}