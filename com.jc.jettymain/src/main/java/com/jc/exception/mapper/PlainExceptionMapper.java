package com.jc.exception.mapper;

import com.jc.dto.ErrorMessageDto;
import com.jc.exception.AppException;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Provider
public class PlainExceptionMapper extends ExceptionMapperBase<Exception> {
    private static final String GENERIC_ERROR_STR = "internal server error";

    @Override
    public Response toResponse(final Exception ex) {
        final AppException appEx = unwrapToAppException(ex);
        final ErrorMessageDto errorMessage;
        if (appEx != null) {
            errorMessage = new ErrorMessageDto(appEx.getStatusCode(), appEx.getMessage(), appEx.getDebugMessage(), ex);
        }
        else {
            errorMessage = new ErrorMessageDto(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, GENERIC_ERROR_STR,
                    ex.getMessage(), ex);
        }
        return getResponseByErrorMessage(errorMessage);
    }

    private AppException unwrapToAppException(final Exception ex) {
        final List<Throwable> throwableList = ExceptionUtils.getThrowableList(ex);
        return (AppException) throwableList.stream()
                .filter(AppException.class::isInstance)
                .findFirst()
                .orElse(null);
    }
}
