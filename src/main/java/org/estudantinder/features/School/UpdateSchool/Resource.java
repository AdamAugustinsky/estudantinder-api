package org.estudantinder.features.School.UpdateSchool;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("school")
@Tag(name = "School")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Resource {
    
    @Inject
    Controller updateSchoolController;

    @PUT
    @Path("{id}")
    @Transactional
    @APIResponse(responseCode = "200", description = "Successfully Updated")
    @APIResponse(responseCode = "404", description = "School ID Not Found")
    @APIResponse(responseCode = "500", description = "Unexpected Error")
    public Response updateSchool(@PathParam("id") Long id, DTO data) throws Exception {
        return updateSchoolController.handle(id, data);
    }

}