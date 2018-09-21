package com.jc.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class FileServer implements IServer {
    @Override
    public Server getServer() {
        final Server server = new Server(8080);

        final ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase(".");

        // add resource handler to server. default handler if resource not found.
        final HandlerList handlerList = new HandlerList(resourceHandler, new DefaultHandler());
        server.setHandler(handlerList);
        return server;
    }
}
