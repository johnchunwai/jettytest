package com.jc.binding;

import com.jc.filter.DynRespFilter;
import com.jc.rest.Hello;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;

/**
 * Using {@code DynamicFeature} to bind a filter at runtime.
 *
 * @see DynRespFilter
 */
@Provider
public class DynamicFilterBinding implements DynamicFeature {
    @Override
    public void configure(final ResourceInfo resourceInfo, final FeatureContext context) {
        final Method resourceMethod = resourceInfo.getResourceMethod();
        final Method getHelloDynMethod;
        try {
            getHelloDynMethod = Hello.class.getMethod("getHelloDyn", String.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Unable to find Hello.getHelloDyn(String) method with reflection");
        }
        if (getHelloDynMethod.equals(resourceMethod)) {
            context.register(DynRespFilter.class);
        }
    }
}
