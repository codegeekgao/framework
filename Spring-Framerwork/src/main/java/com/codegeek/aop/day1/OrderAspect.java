package com.codegeek.aop.day1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
//@Aspect
@Order(1)
public class OrderAspect {


    @Before(value = "execution(* *..aop..*(..))")
    public static void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        //  System.out.println(joinPoint.getStaticPart()); 打印详细切入点表达式

        System.out.println("OrderAspect-普通通知方法@before：" + joinPoint.getSignature().getName() + "日志开始了....方法参数：" + Arrays.asList(args));
    }
    @Pointcut(value = "execution(* *..aop..*(..))")
    public void logPoint() {

    }

    // returning 告诉方法执行完毕后返回的值
    @AfterReturning(value = "execution(public * com.codegeek.aop.day1.CalculatorImpl.*(..))", returning = "result")
    public static void logRun(Object result) {
        System.out.println("OrderAspect-普通通知@AfterReturning" + "运行结果为：" + result);
    }

    @AfterThrowing(value = "execution(public  * com.codegeek.aop.day1.Calculator.*(..))", throwing = "e")
    public static void logException(Exception e) {
        System.out.println("OrderAspect-普通通知@AfterThrowing出异常啦:" + e);
    }

    @After(value = "execution(public  * com.codegeek.aop.day1.Calculator.*(..))")
    public void logEnd() {
        System.out.println("OrderAspect-普通通知@After日志结束了");
    }
}
