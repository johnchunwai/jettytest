package com.jc.rest;


import com.jc.dto.HelloDto;
import com.jc.binding.Authed;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

// This Path is a must have. Or it won't be parsed by Jersey.
@Path("/")
public class Hello {
    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloDto getHello(@HeaderParam("X-Inject") String injectedHeader) {
        final HelloDto helloDto = new HelloDto();
        helloDto.setGreetings("hello");
        helloDto.setTimestamp(System.currentTimeMillis());
        if (injectedHeader != null) {
            helloDto.setInjectedHeaders(injectedHeader);
        }
        return helloDto;
    }

    /**
     * This method goes through filters tagged with {@code @Authed}.
     *
     * @param sid
     * @param headers Since the global filter already injects the {@code X-Inject} header, the
     *                {@coce AuthReqFilter} will add a 2nd header with the same name. If we use {@code @HeaderParam}
     *                to parse it, we'll only get the 1st one injected by global filter. Therefore, we use {@code
     *                Context} to get all headers.
     * @return
     *
     * @see Authed
     * @see com.jc.filter.AuthReqFilter
     */
    @Authed
    @GET
    @Path("hello/authed")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloDto getHelloAuthed(@HeaderParam("X-SID") String sid,
                                   @Context HttpHeaders headers) {
        final HelloDto helloDto = new HelloDto();
        helloDto.setGreetings("hello sid=" + sid);
        helloDto.setTimestamp(System.currentTimeMillis());
        if (headers != null) {
            final List<String> injectedHeaders = headers.getRequestHeader("X-Inject");
            helloDto.setInjectedHeaders(injectedHeaders.stream().collect(Collectors.joining("; ")));
        }
        return helloDto;
    }

    /**
     * {@code DynRespFilter} will at runtime bind this method with the DynRespFilter.

     * @param injectedHeader
     * @return
     *
     * @see com.jc.binding.DynamicFilterBinding
     */
    @GET
    @Path("hello/dyn")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloDto getHelloDyn(@HeaderParam("X-Inject") String injectedHeader) {
        return getHello(injectedHeader);
    }
}
