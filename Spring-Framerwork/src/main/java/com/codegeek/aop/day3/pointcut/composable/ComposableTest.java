package com.codegeek.aop.day3.pointcut.composable;

import com.codegeek.aop.day2.methodbefore.SimpleBeforeAdvice;
import com.codegeek.aop.day3.pointcut.composable.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:/aop/day3/application.xml"})
public class ComposableTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testComposable() {
        // 创建ComposablePointcut 控制流对象并添加AddMethodMatcher实例
        ComposablePointcut pointcut = new ComposablePointcut(ClassFilter.TRUE, new AddMethodMatcher());
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut,new SimpleBeforeAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(applicationContext.getBean(ProductService.class));
        ProductService proxy = (ProductService) proxyFactory.getProxy();
        pointcut.union(new FindMethodMatcher());
        // 添加DeleteMethodMatcher
        pointcut.intersection(new DeleteMethodMatcher());
        proxy.addProduct(new Product("iphone11","河南郑州",new BigDecimal(5700),"电子产品","apple"));
        proxy.addProduct(new Product("小米","广东深圳",new BigDecimal(3200),"电子产品","xiaomi"));
        System.out.println(proxy.findAllProduct());
        System.out.println(proxy.findProductByProductCompany("apple"));
        System.out.println(proxy.findProductByProductName("iphone11"));
    }
}
