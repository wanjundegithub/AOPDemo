package com.company.aop.dto;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
@Aspect
@Slf4j
public class LogAspect {

    /**
     * 定义线程池，使用异步记录日志
     */
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));

    /**
     * 定义切点
     * 定义切面
     * 织入
     */

    @Pointcut("@annotation(com.company.aop.dto.LogService)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        threadPoolExecutor.execute(()->{
            try {
                //通过反射获取方法上的注解
                MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
                //获取方法上的aop注解对象
                LogService logService = methodSignature.getMethod().getAnnotation(LogService.class);
                //拿到convert对象
                Class<? extends LogConvert> clazz = logService.convert();
                LogConvert logConvert = clazz.newInstance();
                //通过转换器接口将不同的id转换成标准的模型
                LogDto logDto = logConvert.convert(proceedingJoinPoint.getArgs()[0]);
                logDto.setResult(result.toString());
                logDto.setDesc(logService.desc());
                log.info("当前订单信息:"+logDto.toString());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return result;
    }
}
