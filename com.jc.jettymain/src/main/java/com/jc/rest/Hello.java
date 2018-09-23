package com.jc.rest;


import com.jc.dto.HelloDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// This Path is a must have. Or it won't be parsed by Jersey.
@Path("/")
public class Hello {
    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloDto getHello() {
//        final HelloDto helloDto = new HelloDto(System.currentTimeMillis(), "hello Jersey!");
        final HelloDto helloDto = new HelloDto();
        helloDto.setGreetings("Hello Jersey");
        helloDto.setTimestamp(System.currentTimeMillis());
        return helloDto;
    }
}
