package com.jc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Copied from jetty embedded example
 */
public class DumpServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html");
        response.setStatus(200);
        PrintWriter out = response.getWriter();
        out.println("<h1>DumpServlet</h1>");
        out.println("<pre>");
        out.println("requestURI=" + request.getRequestURI());
        out.println("requestURL=" + request.getRequestURL().toString());
        out.println("contextPath=" + request.getContextPath());
        out.println("servletPath=" + request.getServletPath());
        out.println("pathInfo=" + request.getPathInfo());
        out.println("session=" + request.getSession(true).getId());
        String r = request.getParameter("resource");
        if (r != null) {
            out.println("resource(" + r + ")=" + this.getServletContext().getResource(r));
        }

        out.println("</pre>");
    }
}