package com.codegeek.aop.day1;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {


    @Before(value = "execution(public int com.codegeek.aop.day1.Calculator.*(int,int))")
    public static void logStart() {
        System.out.println("日志开始了");
    }
    @AfterReturning(value = "execution(public int com.codegeek.aop.day1.CalculatorImpl.*(int,int))")
    public static void logRun() {
        System.out.println("开始运行");
    }

    @AfterThrowing(value = "execution(public  int com.codegeek.aop.day1.Calculator.*(int,int))")
    public static void logException() {
        System.out.println("出异常啦");
    }

    @After(value = "execution(public  int com.codegeek.aop.day1.Calculator.*(int,int))")
    public void logEnd() {
        System.out.println("日志结束了");
    }
}
