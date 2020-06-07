package com.codegeek.aop.day3.pointcut.controlflow;

import com.codegeek.aop.day2.methodbefore.SimpleBeforeAdvice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:aop/day3/*.xml"})
public class controlFlowTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testControlFlowPointcut() {
        System.out.println();
        AccountService accountService = applicationContext.getBean(AccountService.class);
        ControlFlowPointcut pointcut = new ControlFlowPointcut(controlFlowTest.class,"execute");
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut,new SimpleBeforeAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(accountService);
        AccountService proxy = (AccountService) proxyFactory.getProxy();
        System.out.println("第一次执行updateBalanceAndExpress 开始------------------------");
        proxy.updateBalanceAndExpress();
        System.out.println("第一次执行updateBalanceAndExpress 结束------------------------");
        System.out.println("\n"+"第二次执行updateBalanceAndExpress 开始------------------------");
        execute(proxy);
        System.out.println("第二次执行updateBalanceAndExpress 结束------------------------");
    }

    public void execute(AccountService accountService) {
        accountService.updateBalanceAndExpress();
    }
}
