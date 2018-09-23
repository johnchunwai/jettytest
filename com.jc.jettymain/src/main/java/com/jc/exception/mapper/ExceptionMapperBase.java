package com.jc.exception.mapper;

import com.jc.dto.ErrorMessageDto;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public abstract class ExceptionMapperBase<E extends Throwable> implements ExceptionMapper<E> {
    protected Response getResponseByErrorMessage(final ErrorMessageDto errorMessage) {
        return Response.status(errorMessage.getStatusCode())
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}

