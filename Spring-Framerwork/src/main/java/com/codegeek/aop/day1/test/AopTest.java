package com.codegeek.aop.day1.test;

import com.codegeek.aop.day1.*;
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
//@ContextConfiguration(classes = AOPConfig.class)
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
        // 配置切面类IOC就生成接口的代理类否则就是基本类
        System.out.println();
        Calculator bean = applicationContext.getBean(Calculator.class);
        System.out.println(bean.add(1, 5));
        System.out.println("-------------------");
        System.out.println(bean.divide(5, 0));
        System.out.println(bean);
        System.out.println(bean.getClass());
    }


}
