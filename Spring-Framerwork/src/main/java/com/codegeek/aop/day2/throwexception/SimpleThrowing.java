package com.codegeek.aop.day2.throwexception;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class SimpleThrowing implements ThrowsAdvice {

    public void afterThrowing(Exception e) {
        System.out.println("\n" + "抛出的异常是：" + e.getClass().getName());
        System.out.println("错误消息：" + e.getMessage());
        System.out.println("导致的原因是：" + e.getCause());
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
        System.out.println("\n" + "afterThrowing......advice...start");
        System.out.println("\n" + "执行的方法为：" + method.getName());
        System.out.println("抛出的异常是：" + e.getClass().getName());
        System.out.println("错误消息：" + e.getMessage());
        System.out.println("导致的原因是：" + e.getCause());
        System.out.println("\n" + "afterThrowing......advice...end");
    }
}
