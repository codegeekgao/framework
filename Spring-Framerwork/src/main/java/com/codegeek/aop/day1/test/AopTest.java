package com.codegeek.aop.day1.test;

import com.codegeek.aop.day1.Calculator;
import com.codegeek.aop.day1.CalculatorImpl;
import com.codegeek.aop.day1.CalculatorProxy;

import java.lang.reflect.Proxy;

public class AopTest {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        Calculator o = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(), new CalculatorProxy(calculator));
        o.add(1,5);
    }

}
