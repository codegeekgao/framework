package com.codegeek.aop.day5.service.test;

import com.codegeek.aop.day5.service.BuyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author CodeGeekGao
 * @version Id: TestService.java, v 1.0 2020/7/11 11:29 AM CodeGeekGao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:/aop/day5/*.xml"})
public class TestService {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() {
        BuyService buyService = applicationContext.getBean(BuyService.class);
        buyService.buy("小明","Java编程入门",10L);
    }
}
