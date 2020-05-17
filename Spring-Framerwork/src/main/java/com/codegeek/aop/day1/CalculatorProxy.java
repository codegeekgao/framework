package com.codegeek.aop.day1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorProxy implements InvocationHandler {

    private Calculator calculator;

    public CalculatorProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(calculator, args);
        if (method.getName().equals("add")) {
            System.out.println("执行到了..... add...执行结果"+invoke);
        } else if (method.getName().equals("sub")) {
            System.out.println("执行到了.... sub...执行结果"+invoke);
        }
        return invoke;
    }
}
