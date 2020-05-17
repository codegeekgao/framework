package com.codegeek.ioc.day4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:ioc/day4/*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BeanTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testBean() {
        BeanLife bean = applicationContext.getBean(BeanLife.class);
    }

    @Test
    public void testJSR() {
        PostConstructDemo bean = applicationContext.getBean(PostConstructDemo.class);
    }


    @Test
    public void testSpring() {
       // SpringInitDemo bean = applicationContext.getBean(SpringInitDemo.class);
    }
}
