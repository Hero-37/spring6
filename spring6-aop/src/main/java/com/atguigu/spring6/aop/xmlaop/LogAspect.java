package com.atguigu.spring6.aop.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LogAspect {

    // 前置通知
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger --> 前置通知, 增强方法名: " + methodName + ", 参数: " + Arrays.toString(args));
    }

    // 后置通知
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 后置通知, 增强方法名: " + methodName);
    }

    // 返回通知
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 返回通知, 增强方法名: " + methodName + ", 返回结果 result: " + result);
    }

    // 异常通知
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 异常通知, 增强方法名: " + methodName + ", 异常信息: " + ex);
    }

    // 环绕通知
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        Object result = null;
        try {
            System.out.println("环绕通知--目标方法之前执行");

            // 调用目标方法
            result = joinPoint.proceed();

            System.out.println("环绕通知--目标方法返回值之后执行");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知--目标方法出现异常之后执行");
        } finally {
            System.out.println("环绕通知--目标方法执行完毕之后执行");
        }

        return result;
    }

    // 重用切入点表达式
    @Pointcut(value = "execution(* com.atguigu.spring6.aop.xmlaop.CalculatorImpl.*(..))")
    public void pointCut() {

    }
}
