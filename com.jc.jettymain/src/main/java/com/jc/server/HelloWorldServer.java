package com.jc.server;

import com.jc.handler.HelloHandler;
import org.eclipse.jetty.server.Server;

public class HelloWorldServer implements IServer {
    @Override
    public Server getServer() {
        final Server server = new Server(8080);
        server.setHandler(new HelloHandler());
        return server;
    }
}
