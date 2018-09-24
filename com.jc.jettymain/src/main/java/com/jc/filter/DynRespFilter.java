package com.jc.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

/**
 * We test a different type of dynamic binding using {@code DynamicFeature} which can be use for binding things based
 * on method and class.
 * Note that we do not add {@code @Provider} annotation here so that this class is not scanned by the
 * JAX-RS framework. Instead this filter will be called at runtime by the {@code DynamicFilterBinding}, an
 * implementation of {@code DynamicFeature} interface.
 *
 * @see com.jc.binding.DynamicFilterBinding
 */
public class DynRespFilter implements ContainerResponseFilter {
    @Override
    public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext responseContext)
            throws IOException {
        responseContext.getHeaders().add("X-RespFilter", this.getClass().toString());
    }
}
