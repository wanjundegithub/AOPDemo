package com.company.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Aspect
@Component
@Slf4j
public class UserAspect {

    @Before("execution(* com.company.aop.service.UserService.*(..))")
    public void before(JoinPoint joinPoint){
        log.info("before update user");
    }
}
