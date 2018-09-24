package com.jc.binding;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to tag filters as well as tagging methods/class that needs to use those filters.
 * This could apply to classes, methods, packages, or anything depending on {@code @Target(<ElementType[])}.
 *
 * Eg. If {@code MyFilter1} and {@code MyFilter2} are tagged by {@code @Authed}.
 *     and {@code Class1} and {@code Class2.method1} are tagged by {@code @Authed},
 *     then, {@code  MyFilter1} and {@code MyFilter2} will be triggered when:
 *     1) any methods for {@code Class1} are invoked
 *     2) {@code Class2.method1} is invoked.
 *
 * @see com.jc.filter.AuthReqFilter
 * @see com.jc.rest.Hello
 */
@NameBinding
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authed {
}
