package com.codegeek.aop.day3.jdkproxy;

import com.codegeek.aop.day3.cglibproxy.CalculatorCGLIBProxy;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ContextConfiguration(locations = {"classpath:aop/day3/application.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProxyTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testJdkProxy() {
        Calculator calculator = new CalculatorImpl();
        Calculator o = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(), new CalculatorJDKProxy(calculator));
        Double divide = o.divide(250.0, 5.0);
        System.out.println("输出的值为：" + divide);
    }

    @Test
    public void testCGLIB() {
        Enhancer enhancer = new Enhancer();
        System.out.println();
        enhancer.setSuperclass(CalculatorImpl.class);
        enhancer.setCallback(new CalculatorCGLIBProxy());
        Calculator o = (Calculator) enhancer.create();
        Double divide = o.divide(500.0, 3.0);
        System.out.println(divide);
    }


    @Test
    public void testPerformance() {
        Calculator calculator = new CalculatorImpl();
        Calculator o = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(), new CalculatorJDKProxy(calculator));
        Random random = new Random();
        List<Double> list = new ArrayList<>(1000);

        for (int i = 1; i < 1000; i++) {
            double a = (random.nextInt(i) + 1)*1.0;
            double b = (random.nextInt(i) + 1)*1.0;
            Double result = o.divide(a,b);
            list.add(result);
        }

        Double aDouble = list.stream().max(Double::compareTo).get();
        System.out.println("");
    }
}
