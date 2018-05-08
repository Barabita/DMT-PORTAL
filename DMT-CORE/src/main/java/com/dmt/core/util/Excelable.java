package com.dmt.core.util;

/*
 * @author mali.sahin
 * @since 3.05.2018.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public  @interface Excelable {
    public boolean enabled() default true;

    public String value() default "";
}
