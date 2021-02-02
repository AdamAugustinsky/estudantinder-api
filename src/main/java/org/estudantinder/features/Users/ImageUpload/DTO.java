package org.estudantinder.features.Users.ImageUpload;

import java.io.File;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class DTO {

    @NotNull(message = "profile photo must be inserted")
    @FormParam("photo0")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File photo0;

    @FormParam("photo1")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File photo1;

    @FormParam("photo2")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File photo2;

    @FormParam("photo3")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File photo3;
    
    @FormParam("photo4")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File photo4;

    @FormParam("photo5")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File photo5;

}