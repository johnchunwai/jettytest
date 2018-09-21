package com.jc.handler;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloHandler extends AbstractHandler {

    private final String greetings;

    public HelloHandler() {
        this.greetings = "Hello World";
    }

    public HelloHandler(final String greetings) {
        this.greetings = greetings;
    }

    @Override
    public void handle(final String target, final Request baseRequest, final HttpServletRequest request,
                       final HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>" + greetings + "</h1>");
        baseRequest.setHandled(true);
    }
}
