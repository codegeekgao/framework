package com.codegeek.aop.day2.after;

import org.springframework.aop.AfterAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SimpleAfterService implements AfterAdvice {

    public void after(Method method,Object [] args,Object target) {
        System.out.println("执行的方法名："+method.getName());
        System.out.println("执行参数："+ Arrays.asList(args));
        System.out.println("执行的目标类："+target.getClass().getName());
    }
}
