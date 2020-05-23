package com.codegeek.ioc.day2.replacemethod;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.Arrays;

public class UserReplaceMethod implements MethodReplacer {

    /***
     *
     *   @Override
     *     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
     *
     *         return proxy;
     *     }
     */
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("执行的方法:" + method.getName());
        System.out.println("参数："+ Arrays.stream(args).findFirst().get()) ;
        System.out.println("我是MethodReplacer......替换后的方法");
        return obj;
    }
}
