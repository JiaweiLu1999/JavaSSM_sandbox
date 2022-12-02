package com.jiawei.spring_aop.example.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyLog {
    @Pointcut("execution(* com.jiawei.spring_aop.example.impl.CalcImpl.*(..))")
    public void myPointCut() {}

//    @Before(value = "myPointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("==> [Before Method] Calc: method->" + methodName + ", params->" + Arrays.toString(args));
    }

//    @After(value = "myPointCut()")
    public static void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("==> [After Method] Calc: method->" + methodName + ", params->" + Arrays.toString(args));
    }

//    @AfterReturning(value = "myPointCut()", returning = "result")
    public static void afterReturn(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("==> [After Return] Calc: method->" + methodName + ", return->" + result);
    }

    @Around(value = "myPointCut()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {

        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        Object result;

        try {
            // Before
            System.out.println("==> [Before Method] Calc: method->" + methodName + ", params->" + Arrays.toString(args));
            // Execute
            result = proceedingJoinPoint.proceed();
            // Return
            System.out.println("==> [After Return] Calc: method->" + methodName + ", return->" + result);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            // After
            System.out.println("==> [After Method] Calc: method->" + methodName + ", params->" + Arrays.toString(args));
        }

        return result;
    }
}