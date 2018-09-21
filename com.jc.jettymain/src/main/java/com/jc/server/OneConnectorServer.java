package com.jc.server;

import com.jc.handler.HelloHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class OneConnectorServer implements IServer {
    @Override
    public Server getServer() {
        final Server server = new Server();
        final var connector = new ServerConnector(server);
        connector.setHost("localhost");
        connector.setPort(8080);
        connector.setIdleTimeout(30000);
        server.addConnector(connector);
        server.setHandler(new HelloHandler());
        return server;
    }
}
