package com.codegeek.ioc.day5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ioc/day5/*.xml"})
public class SpringTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testBeanPostProcessor() {
      //  Order bean = applicationContext.getBean("order",Order.class);
    }
}
