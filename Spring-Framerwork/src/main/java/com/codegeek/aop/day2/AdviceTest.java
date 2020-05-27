package com.codegeek.aop.day2;

import com.codegeek.aop.day2.after.SimpleAfterService;
import com.codegeek.aop.day2.afterReturning.SimpleAfterReturningAdvice;
import com.codegeek.aop.day2.around.MessagePrinter;
import com.codegeek.aop.day2.around.SimpleAroundAdvice;
import com.codegeek.aop.day2.methodbefore.EmployeeService;
import com.codegeek.aop.day2.methodbefore.SimpleBeforeAdvice;
import com.codegeek.aop.day2.throwexception.CalculateService;
import com.codegeek.aop.day2.throwexception.SimpleThrowing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:/aop/day2/*.xml"})
public class AdviceTest {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 前置通知前需要给proxyFactory设置通知以及代理对象
     */
    @Test
    public void testBefore() {
        ProxyFactory proxyFactory = new ProxyFactory();
        SimpleBeforeAdvice simpleBeforeAdvice = new SimpleBeforeAdvice();
        proxyFactory.addAdvice(simpleBeforeAdvice);
        proxyFactory.setTarget(applicationContext.getBean(EmployeeService.class));
        // 获取代理对象
        EmployeeService proxy = (EmployeeService) proxyFactory.getProxy();
        System.out.println(proxy.getEmployeeName(1));
    }

    @Test
    public void testAfterReturning() {
        ProxyFactory proxyFactory = new ProxyFactory();
        SimpleAfterReturningAdvice simpleAfterReturningAdvice = new SimpleAfterReturningAdvice();
        proxyFactory.addAdvice(simpleAfterReturningAdvice);
        proxyFactory.setTarget(applicationContext.getBean(EmployeeService.class));
        EmployeeService proxy = (EmployeeService) proxyFactory.getProxy();
        System.out.println(proxy.getEmployeeName(0));
    }


    @Test
    public void testAround() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleAroundAdvice());
        proxyFactory.setTarget(new MessagePrinter());
        MessagePrinter proxy = (MessagePrinter) proxyFactory.getProxy();
        proxy.print(1000000);
    }

    @Test
    public void testThrowing() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleThrowing());
        proxyFactory.setTarget(applicationContext.getBean(CalculateService.class));
        CalculateService proxy = (CalculateService) proxyFactory.getProxy();
        proxy.divide(5, 0);
    }
    @Test
    public void testAfter() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleAfterService());
        proxyFactory.setTarget(applicationContext.getBean(CalculateService.class));
        CalculateService proxy = (CalculateService) proxyFactory.getProxy();
        proxy.divide(5, 6);
    }


    @Test
    public void testAll() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
    }
}
