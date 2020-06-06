package com.codegeek.aop.day3.jdkproxy;

import com.codegeek.aop.day2.methodbefore.SimpleBeforeAdvice;
import com.codegeek.aop.day3.cglibproxy.CalculatorCGLIBProxy;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

import java.lang.reflect.Proxy;
import java.util.*;

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
        //TODO JDK代理使用
        Map<String, String> map = new HashMap<>();
        Calculator calculator = new CalculatorImpl();
        Random random = new Random();
        // 创建Spring的计算类对象
        StopWatch stopWatch = new StopWatch();
        String taskName = "JDK代理";
        stopWatch.start(taskName);
        Calculator o = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(), new CalculatorJDKProxy(calculator));
        List<Double> list = new ArrayList<>(1000);
        addNumToList(o, random, list);
        Double aDouble = list.stream().max(Double::compareTo).get();
        System.out.println("JDK计算比较结束，集合最大的值为：" + aDouble);
        stopWatch.stop();
        map.put(taskName, stopWatch.prettyPrint());
        list.clear();

        //TODO CGLIB代理使用
        taskName = "CGLIB代理";
        stopWatch = new StopWatch();
        stopWatch.start(taskName);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CalculatorImpl.class);
        enhancer.setCallback(new CalculatorCGLIBProxy());
        Calculator o1 = (Calculator) enhancer.create();
        addNumToList(o1, random, list);
        System.out.println("CGLIB计算比较结束，集合最大的值为：" + aDouble);
        stopWatch.stop();
        map.put(taskName, stopWatch.prettyPrint());
        System.out.println(map);
    }

    public void runCGLIBTest(ProxyFactory proxyFactory, Calculator calculator, int num, Map<String, Long> map) {
        // 当结果为true将使用CGLIB代理否则为JDK代理，默认为false
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setFrozen(true);
        testCode(calculator, num, map);
    }

    public void runJDKTest(ProxyFactory proxyFactory, Calculator calculator, int num, Map<String, Long> map) {
        // 当结果为true将使用CGLIB代理否则为JDK代理，默认为false
        proxyFactory.setProxyTargetClass(false);
        proxyFactory.setInterfaces(calculator.getClass().getInterfaces());
        testCode(calculator, num, map);
    }

    public void testCode(Calculator calculator, int num, Map<String, Long> map) {

        StopWatch stopWatch = new StopWatch();
        Random random = new Random();
        stopWatch.start("divide");
        List<Double> list = new ArrayList<>();
        addNumToList(calculator, random, list);
        Double aDouble = list.stream().max(Double::compareTo).get();
        System.out.println("计算比较结束，集合最大的值为：" + aDouble);
        stopWatch.stop();
        map.put("divide", stopWatch.getLastTaskTimeMillis());
        stopWatch.start("equals");
        for (int i = 0; i < num; i++) {
            calculator.equals(calculator);
        }
        stopWatch.stop();
        map.put("equals", stopWatch.getLastTaskTimeMillis());

        stopWatch.start("hashCode");
        for (int i = 0; i < num; i++) {
            calculator.hashCode();
        }
        stopWatch.stop();
        map.put("hashCode", stopWatch.getLastTaskTimeMillis());


        Advised advised = (Advised) calculator;
        stopWatch.start("hashCode");
        for (int i = 0; i < num; i++) {
            advised.getTargetClass();
        }
        stopWatch.stop();
        map.put("advised.getTargetClass()", stopWatch.getLastTaskTimeMillis());
    }

    @Test
    public void testProxyPerformance() {
        Map<String, Long> map = new HashMap<>();
        Calculator calculator = applicationContext.getBean("calculator", Calculator.class);
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("divide");
        PointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(pointcutAdvisor);
        proxyFactory.setTarget(calculator);
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        runCGLIBTest(proxyFactory, proxy, 5000000, map);
        System.out.println("CGLIB---map:"+map);
        map.clear();
        runJDKTest(proxyFactory, proxy, 5000000, map);
        System.out.println("JDK---map:"+map);
    }


    private void addNumToList(Calculator o, Random random, List<Double> list) {
        for (int i = 1; i < 10000; i++) {
            double a = (random.nextInt(i) + 1) * 1.0;
            double b = (random.nextInt(i) + 1) * 1.0;
            Double result = o.divide(a, b);
            list.add(result);
        }
    }
}
