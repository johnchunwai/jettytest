package com.jc.server;

import com.jc.handler.HelloHandler;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

public class ManyContextServer implements IServer {
    @Override
    public Server getServer() {
        final Server server = new Server(8080);

        final ContextHandler context = new ContextHandler("/");
        context.setHandler(new HelloHandler());
        final ContextHandler contextFr = new ContextHandler("/fr");
        contextFr.setHandler(new HelloHandler("Bonjoir"));
        final ContextHandler contextIt = new ContextHandler("/it");
        contextIt.setHandler(new HelloHandler("Bongiorno"));

        final ContextHandler contextV = new ContextHandler("/");
        contextV.setVirtualHosts(new String[] {"127.0.0.2"});
        contextV.setHandler(new HelloHandler("Virtual Hello"));

        // NOTE: The caller needs to have a final "/" at the URL for these to work.
        final var contexts = new ContextHandlerCollection(contextFr, context, contextIt, contextV);
//        final var contexts = new ContextHandlerCollection();
//        contexts.setHandlers(new Handler[] {context, contextFr, contextIt, contextV});

        server.setHandler(contexts);
        return server;
    }
}
