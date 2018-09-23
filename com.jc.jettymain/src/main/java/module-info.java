open module com.jc.jettymain {
    requires jetty.server;
    requires javax.servlet.api;
    requires jetty.servlet;
    requires jersey.server;
    requires jersey.container.servlet.core;
    requires static java.ws.rs;
    requires jersey.common;
    requires java.xml.bind;
//    requires jersey.media.json.jackson;
//    requires jersey.hk2;
//    requires jersey.container.jetty.http;
//    requires java.activation;
    requires static lombok;


//    opens com.jc.servlet to jetty.servlet, jetty.server;
//    opens com.jc.rest;
}