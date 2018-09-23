package com.jc.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

public class JerseyServer implements IServer {
    @Override
    public Server getServer() {
        final Server server = new Server(8080);

        final ResourceConfig config = new ResourceConfig();
        config.packages("com.jc.rest");

        // For debugging only
//        config.property(ServerProperties.TRACING, "ALL");
//        config.property(ServerProperties.TRACING_THRESHOLD, "VERBOSE");

        final ServletContainer jerseyServlet = new ServletContainer(config);
        final ServletHolder servletHolder = new ServletHolder(jerseyServlet);

        final var context = new ServletContextHandler(server, "/jc", ServletContextHandler.SESSIONS);
        context.addServlet(servletHolder, "/*");

        return server;
    }
}
