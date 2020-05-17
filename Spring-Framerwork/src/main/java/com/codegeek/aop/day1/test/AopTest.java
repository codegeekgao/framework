package com.codegeek.aop.day1.test;

import com.codegeek.aop.day1.Calculator;
import com.codegeek.aop.day1.CalculatorImpl;
import com.codegeek.aop.day1.CalculatorProxy;
import com.codegeek.aop.day1.LogAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;
@Slf4j
@ContextConfiguration(locations = "classpath:aop/day1/*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AopTest {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        Calculator o = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(), new CalculatorProxy(calculator));
        o.add(1,5);
    }

    @Test
    public void testAspect() {
        Calculator bean = applicationContext.getBean(Calculator.class);
        System.out.println(bean.add(1, 5));
    }


}
