package com.codegeek.aop.day3.pointcut;

import com.codegeek.aop.day1.Calculator;
import com.codegeek.aop.day1.CalculatorImpl;
import com.codegeek.aop.day2.methodbefore.SimpleBeforeAdvice;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
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
}
