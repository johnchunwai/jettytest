package com.jc.exception.mapper;

import com.jc.dto.ErrorMessageDto;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class PlainExceptionMapper extends ExceptionMapperBase<Exception> {
    private static final String GENERIC_ERROR_STR = "internal server error";

    @Override
    public Response toResponse(final Exception ex) {
        final var errorMessage = new ErrorMessageDto(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, GENERIC_ERROR_STR,
                ex.getMessage(), ex);
        return getResponseByErrorMessage(errorMessage);
    }
}
