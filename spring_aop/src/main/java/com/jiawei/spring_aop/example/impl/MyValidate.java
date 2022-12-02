package com.jiawei.spring_aop.example.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class MyValidate {
    @Before("com.jiawei.spring_aop.example.impl.MyLog.myPointCut()")
    public void methodBefore(JoinPoint joinPoint) {
        System.out.println("==> [Before Method] starts...");
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("==> Validate the args...");

    }
}
