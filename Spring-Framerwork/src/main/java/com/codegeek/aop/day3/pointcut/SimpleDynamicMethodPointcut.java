package com.codegeek.aop.day3.pointcut;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicMethodPointcut extends DynamicMethodMatcherPointcut {
    /**
     * 此抽象方法必须被重写
     *
     * @param method
     * @param targetClass
     * @param args
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        // 匹配add方法
        Integer sum = 0;
        for (Object arg : args) {
            Integer a = (Integer) arg;
            sum += a;
        }
        if (method.getName().equals("add") && sum > 50) return true;
        return false;
    }
}
