package com.codegeek.aop.day2.afterReturning;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("\n"+"当前执行对象："+target);
        System.out.println("执行方法名称："+method.getName());
        System.out.println("执行方法参数："+ Arrays.asList(args));
        System.out.println("执行方法的返回值："+returnValue);
    }
}
