package com.jc.exception;

import lombok.Getter;

@Getter
public class AppException extends Exception {
    private static final long serialVersionUID = -4226709204452163869L;

    private final int statusCode;
    private final String debugMessage;

    public AppException(final int statusCode, final String message, final String debugMessage, final Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
        this.debugMessage = debugMessage;
    }

    public AppException(final int statusCode, final String message, final String debugMessage) {
        super(message);
        this.statusCode = statusCode;
        this.debugMessage = debugMessage;
    }
//
//    public int getStatusCode() {
//        return this.statusCode;
//    }
//
//    public String getDebugMessage() {
//        return this.debugMessage;
//    }
}
