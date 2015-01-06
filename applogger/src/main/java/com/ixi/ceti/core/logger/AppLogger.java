package com.ixi.ceti.core.logger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Generic Application Logger Annotation.
 * Created by adixit on 1/5/15.
 */
@Retention(RUNTIME)
@Target({FIELD})
@Documented
public @interface AppLogger {
}
