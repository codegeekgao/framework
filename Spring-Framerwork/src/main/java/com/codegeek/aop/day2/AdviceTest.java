package com.codegeek.aop.day2;

import com.codegeek.aop.day2.methodbefore.EmployeeService;
import com.codegeek.aop.day2.methodbefore.SimpleBeforeAdvice;
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
}
