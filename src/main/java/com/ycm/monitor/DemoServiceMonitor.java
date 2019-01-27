package com.ycm.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class DemoServiceMonitor {

    @Before(value = "execution(* com.ycm.service.*Service*.*(..))")
    public void logServiceMessage2(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        System.out.println("[BEFORE-" + className + "." + methodName + "()]\t\t"
                            + Arrays.toString(arguments));
    }

    @AfterReturning(value = "execution(* com.ycm.service.*Service*.*(..))", returning = "returnValue")
    public void logServiceMessage(JoinPoint joinPoint, Object returnValue) {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[AFTER-" + className + "." + methodName + "()]\t\t"
                            + returnValue);
    }

}