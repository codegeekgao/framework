package com.codegeek.aop.day3.jdkproxy;

import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class CalculatorJDKProxy implements InvocationHandler {

    private Object proxyTarget;

    public CalculatorJDKProxy(Object proxyTarget) {
        this.proxyTarget = proxyTarget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("\n"+"JDK代理方法执行之前执行的程序逻辑");
        List<Object> objects = Arrays.asList(args);
        double sum = objects.stream().mapToDouble(e -> Double.parseDouble(e.toString().trim())).sum();
        if (sum > 50.0) {
            System.out.println("计算的值大于50了");
        }
        Object invoke = method.invoke(proxyTarget, args);
        System.out.println("JDK代理执行之后的程序逻辑");
        // 代理之和的执行程序
        return invoke;
    }
}
