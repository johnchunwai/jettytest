package com.jc.jettymain;

import com.jc.server.*;
import org.eclipse.jetty.server.Server;

public class JettyMain {
    public static void main(String[] args) throws Exception {
//        final Server server = new HelloWorldServer().getServer();
//        final Server server = new FileServer().getServer();
//        final Server server = new OneConnectorServer().getServer();
//        final Server server = new MinimalServletServer().getServer();
//        final Server server = new OneContextServer().getServer();
//        final Server server = new ManyContextServer().getServer();
//        final Server server = new OneServletContextServer().getServer();
//        final Server server = new JerseyServer().getServer();
//        final Server server = new JerseyServerWithErrorMapper().getServer();
        final Server server = new JerseyServerWithFilterWithErrorMapper().getServer();

        server.start();
        server.join();
    }
}
