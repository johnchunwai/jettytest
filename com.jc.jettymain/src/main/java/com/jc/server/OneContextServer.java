package com.jc.server;

import com.jc.handler.HelloHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;

public class OneContextServer implements IServer {
    @Override
    public Server getServer() {
        final Server server = new Server(8080);

        final ContextHandler context = new ContextHandler("/");
        context.setHandler(new HelloHandler());

        server.setHandler(context);
        return server;
    }
}
