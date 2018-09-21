package com.jc.server;

import com.jc.servlet.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class MinimalServletServer implements IServer {
    @Override
    public Server getServer() {
        final Server server = new Server(8080);
        final ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        // raw servlet, not through web.xml or @WebServlet annotation or anything similar
        handler.addServletWithMapping(HelloServlet.class, "/hi");

        return server;
    }
}
