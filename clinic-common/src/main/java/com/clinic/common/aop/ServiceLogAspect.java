package com.clinic.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: majunjie
 * @Date: 2021年2月20日$ 01点22分$
 * @Description:
 */
@Slf4j
@Component
@Aspect
public class ServiceLogAspect {


    @Pointcut("execution( * com.clinic.provider.controller.*.*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("======开始执行======");
        Object proceed = joinPoint.proceed();
        log.info("======执行结束======");
        return proceed;
    }


}
