package com.codegeek.aop.day2.methodbefore;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("\n" + "before......advice....start");
        System.out.println("执行的方法是：" + method.getName());
        System.out.println("执行的参数是：" + Arrays.asList(args));
        System.out.println("执行的对象是：" + target);
        System.out.println("before......advice...end");
    }
}
