package org.estudantinder.features.Schools.DeleteSchool;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("schools")
@Tag(name = "Schools")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {
    
    @Inject
    Controller deleteSchoolController;

    @DELETE
    @Path("{id}")
    @Transactional
    @APIResponse(responseCode = "200", description = "Successfully Updated")
    @APIResponse(responseCode = "404", description = "School ID Not Found")
    @APIResponse(responseCode = "500", description = "Unexpected Error")
    @Operation(summary = "Delete given Id School")
    public Response deleteSchool(@PathParam("id") Long id) throws Exception {
        return deleteSchoolController.handle(id);
    }

}
