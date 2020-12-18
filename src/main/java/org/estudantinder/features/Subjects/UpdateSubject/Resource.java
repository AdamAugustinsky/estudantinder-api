package org.estudantinder.features.Subjects.UpdateSubject;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("subject")
@Tag(name = "Subject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Resource {
    
    @Inject
    Controller updateSubjectController;

    @PUT
    @Path("{id}")
    @Transactional
    @APIResponse(responseCode = "200", description = "Successfully Updated")
    @APIResponse(responseCode = "404", description = "Subject ID Not Found")
    @APIResponse(responseCode = "500", description = "Unexpected Error")
    @Operation(summary = "Update given Id Subject")
    public Response updateSubject(@PathParam("id") Long id, DTO data) throws Exception {
        return updateSubjectController.handle(id, data);
    }

}
