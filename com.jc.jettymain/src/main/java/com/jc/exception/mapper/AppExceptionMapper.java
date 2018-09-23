package com.jc.exception.mapper;

import com.jc.dto.ErrorMessageDto;
import com.jc.exception.AppException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AppExceptionMapper extends ExceptionMapperBase<AppException> {
    @Override
    public Response toResponse(final AppException ex) {
        final var errorMessage = new ErrorMessageDto(ex.getStatusCode(), ex.getMessage(), ex.getDebugMessage(), ex);
        return getResponseByErrorMessage(errorMessage);
    }
}
