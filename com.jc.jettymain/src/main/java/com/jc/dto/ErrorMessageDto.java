package com.jc.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@Getter
@Setter
public class ErrorMessageDto {
    private static final boolean INCLUDE_CALLSTACK = false;

    private int statusCode;
    private String message;
    private String debugMessage;
    private String callStack;

    public ErrorMessageDto(final int statusCode, final String message, final String debugMessage, final Exception ex) {
        this.statusCode = statusCode;
        this.message = message;
        this.debugMessage = debugMessage;
        this.callStack = getCallStack(ex);
    }

    private String getCallStack(final Exception ex) {
        if (INCLUDE_CALLSTACK) {
            try (var sw = new StringWriter();
                 var pw = new PrintWriter(sw)) {
                ex.printStackTrace(pw);
                return sw.toString();
            } catch (IOException e) {
                // eat it.
            }
        }
        return "";
    }

//    public int getStatusCode() {
//        return statusCode;
//    }
//
//    public void setStatusCode(final int statusCode) {
//        this.statusCode = statusCode;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(final String message) {
//        this.message = message;
//    }
//
//    public String getDebugMessage() {
//        return debugMessage;
//    }
//
//    public void setDebugMessage(final String debugMessage) {
//        this.debugMessage = debugMessage;
//    }
//
//    public String getCallStack() {
//        return callStack;
//    }
//
//    public void setCallStack(final String callStack) {
//        this.callStack = callStack;
//    }
}
