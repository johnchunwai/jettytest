package com.jc.exception.mapper;

import com.jc.dto.ErrorMessageDto;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper extends ExceptionMapperBase<WebApplicationException> {
    @Override
    public Response toResponse(final WebApplicationException ex) {
        final var errorMessage = new ErrorMessageDto(ex.getResponse().getStatus(), ex.getMessage(),
                ex.getResponse().toString(), ex);
        return getResponseByErrorMessage(errorMessage);
    }
}
