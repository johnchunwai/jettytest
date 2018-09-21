package com.jc.server;

import com.jc.servlet.DumpServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class OneServletContextServer implements IServer {
    @Override
    public Server getServer() {
        final Server server = new Server(8080);

        final var context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/hi");
        context.setResourceBase(System.getProperty("java.io.tmpdir"));
        server.setHandler(context);

        context.addServlet(DumpServlet.class, "/dump/*");
        context.addServlet(DefaultServlet.class, "/");

        return server;
    }
}
