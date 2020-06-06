package com.codegeek.aop.day3.jdkproxy;

import com.sun.tools.doclint.Entity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

import static com.sun.tools.doclint.Entity.divide;

@ContextConfiguration(locations = {"classpath:aop/day3/application.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProxyTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testJdkProxy() {
        Calculator calculator = new CalculatorImpl();
        Calculator o = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(), new CalculatorProxy(calculator));
        Double divide = o.divide(1.0, 5.0);
        System.out.println("输出的值为："+ divide);
    }
}
