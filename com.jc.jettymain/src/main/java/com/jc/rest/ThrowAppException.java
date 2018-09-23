package com.jc.rest;


import com.jc.dto.HelloDto;
import com.jc.exception.AppException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// This Path is a must have. Or it won't be parsed by Jersey.
@Path("/")
public class ThrowAppException {
    @GET
    @Path("appex518")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloDto getThrowAppException518() throws AppException {
        throw new AppException(518, "throw by ThrowException.getThrowAppException518", "some debug stuff");
    }

    @GET
    @Path("appex444")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloDto getThrowAppException444() throws AppException {
        throw new AppException(444, "throw by ThrowException.getThrowAppException444", "some debug stuff 444");
    }

    @GET
    @Path("ex")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloDto getThrowException() throws Exception {
        throw new Exception("throw by ThrowException.getThrowException");
    }
}
