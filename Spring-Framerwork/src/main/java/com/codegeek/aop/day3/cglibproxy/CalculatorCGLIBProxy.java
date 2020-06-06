package com.codegeek.aop.day3.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class CalculatorCGLIBProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB代理之前执行的程序逻辑");
        // 执行被代理对象的方法
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        List<Object> list = Arrays.asList(objects);
        double sum = list.stream().mapToDouble(e -> Double.parseDouble(e.toString().trim())).sum();
        if (sum > 50.0) {
            System.out.println("计算的值大于50了");
        }
        System.out.println("CGLIB代理之后执行的程序逻辑");
        return invokeSuper;
    }
}
