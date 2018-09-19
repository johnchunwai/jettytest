package com.jc.jettymain;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JettyMain extends AbstractHandler {
    public static void main(String[] args) throws Exception {
        final Server server = new Server(8080);
        server.setHandler(new JettyMain());

        server.start();
        server.join();
    }

    @Override
    public void handle(final String target, final Request baseRequest, final HttpServletRequest request,
                       final HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("<h1>Hello World</h1>");
    }
}
