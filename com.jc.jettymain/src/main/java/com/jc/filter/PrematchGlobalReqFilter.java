package com.jc.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * This filter applies globally to all jersey requests and it runs before URL pattern matching.
 */
@Provider
@PreMatching
public class PrematchGlobalReqFilter implements ContainerRequestFilter {
    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add("X-Inject", this.getClass().toString());
    }
}
