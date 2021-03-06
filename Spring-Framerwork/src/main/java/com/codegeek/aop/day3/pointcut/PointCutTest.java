package com.codegeek.aop.day3.pointcut;

import com.codegeek.aop.day1.Calculator;
import com.codegeek.aop.day1.CalculatorImpl;
import com.codegeek.aop.day2.methodbefore.SimpleBeforeAdvice;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:/aop/day3/application.xml"})
@Slf4j
public class PointCutTest {

    /**
     * NameMatchMethodPointcut+BeforeAdvice
     */
    @Test
    public void testNameMatchMethodPointcut() {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("add");
        pointcut.addMethodName("sub");
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        int add = proxy.add(1, 5);
        log.info("加法计算值:{}", add);
        double divide = proxy.divide(10, 10);
        log.info("除法计算值:{}", divide);
    }

    @Test
    public void testJdkRegexPointCut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        // 设置匹配所以以get开头的方法
        pointcut.setPattern(".*get");
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();

        int add = proxy.add(1, 5);
        log.info("加法计算值:{}", add);
        double divide = proxy.divide(10, 10);
        log.info("除法计算值:{}", divide);
    }

    @Test
    public void testDynamicMethod() {
        SimpleDynamicMethodPointcut pointcut = new SimpleDynamicMethodPointcut();
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new CalculatorImpl());//12121
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        System.out.println();
        int add = proxy.add(5, 5);
        log.info("加法计算值:{}", add);
    }

    @Test
    public void testAspectExpressionPointcut() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* *..aop.*day1..*(..))");
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        System.out.println();
        int add = proxy.add(5, 5);
        log.info("加法计算值:{}", add);
    }

    @Test
    public void testAnnotationPointcut() {
        // 获取方法的注解的实例
        AnnotationMatchingPointcut pointcut =  AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut,new SimpleBeforeAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new CalculatorImpl());
        proxyFactory.addAdvisor(advisor);
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        int sub = proxy.sub(5, 5);
        log.info("减法计算值:{}", sub);
        int add = proxy.add(5, 5);
        log.info("加法计算值:{}", add);
    }
}
