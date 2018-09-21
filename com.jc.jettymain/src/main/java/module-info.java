module com.jc.jettymain {
    requires jetty.server;
    requires javax.servlet.api;
    requires jetty.servlet;

    opens com.jc.servlet to jetty.servlet, jetty.server;
}