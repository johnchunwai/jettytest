package com.jc.filter;

import com.jc.binding.Authed;
import com.jc.exception.AppException;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

//import javax.ws.rs.Priorities;

/**
 * This applies only to things tagged with the custom annotation {@code @Authed} and is run after URL pattern
 * matching. It wouldn't work prematch because before identifying the class/method, there is no way to know if the
 * {@code @Authed} annotation is present.
 *
 * {@code Priority} that takes a number (smaller runs first) decides on the order of the filters being run when
 * multiple filters are mapped to a request/response.
 *
 * @see Authed
 * @see com.jc.rest.Hello
 */
@Provider
@Authed
@Priority(Priorities.AUTHENTICATION)
public class AuthReqFilter implements ContainerRequestFilter {
    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException {
        final String sid = requestContext.getHeaderString("X-SID");
        if (sid == null) {
            // NOTE: We could wrap AppException in IOException and still show the proper response because we added
            // the error mapping and perform the proper exception unwrapping. Otherwise, we need to do the following
            // abortWith.

//            requestContext.abortWith(Response.status(HttpServletResponse.SC_UNAUTHORIZED)
//                    .entity("please auth")
//                    .build());
            throw new IOException(new AppException(HttpServletResponse.SC_UNAUTHORIZED, "please auth", "no session"));
        }
        // NOTE: first call updates the header; 2nd call adds a new one. Since the global filter already injects the
        // header, the 2nd call will add a 2nd header with the same name. If we use {@code @HeaderParam} to parse it,
        // we'll only get the 1st one injected by global filter.
//        requestContext.getHeaders().putSingle("X-Inject", "Authed");
        requestContext.getHeaders().add("X-Inject", "Authed");
    }
}
