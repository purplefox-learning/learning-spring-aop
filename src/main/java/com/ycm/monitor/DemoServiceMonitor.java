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
        System.out.println("[BEFORE]\t" + getJoinPointInfo(joinPoint,true));
    }

    @AfterReturning(value = "execution(* com.ycm.service.*Service*.*(..))", returning = "returnValue")
    public void logServiceMessage(JoinPoint joinPoint, Object returnValue) {
        System.out.println("[AFTER ]\t" + getJoinPointInfo(joinPoint,false)
                            + "\t" + returnValue);
    }

    private String getJoinPointInfo(JoinPoint joinPoint, boolean includeArguments) {
        StringBuilder sb = new StringBuilder();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        sb.append(className);
        sb.append('.');
        sb.append(methodName);
        sb.append('(');
        if (includeArguments) sb.append(Arrays.toString(arguments));
        sb.append(')');
        return sb.toString();
    }
}