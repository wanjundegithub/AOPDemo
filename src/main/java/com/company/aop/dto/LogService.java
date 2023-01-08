package com.company.aop.dto;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogService {

    String desc() default "";

    Class<? extends LogConvert> convert() ;
}
