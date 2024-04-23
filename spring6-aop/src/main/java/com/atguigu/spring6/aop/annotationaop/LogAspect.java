package com.atguigu.spring6.aop.annotationaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    @Before(value = "execution(public int com.atguigu.spring6.aop.annotationaop.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger --> 前置通知, 增强方法名: " + methodName + ", 参数: " + Arrays.toString(args));
    }

    @After(value = "execution(* com.atguigu.spring6.aop.annotationaop.CalculatorImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 后置通知, 增强方法名: " + methodName);
    }

    @AfterReturning(value = "execution(* com.atguigu.spring6.aop.annotationaop.CalculatorImpl.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 返回通知, 增强方法名: " + methodName + ", 返回结果 result: " + result);
    }

    @AfterThrowing(value = "execution(* com.atguigu.spring6.aop.annotationaop.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 异常通知, 增强方法名: " + methodName + ", 异常信息: " + ex);
    }

    @Around(value = "execution(* com.atguigu.spring6.aop.annotationaop.CalculatorImpl.*(..))")
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
}
