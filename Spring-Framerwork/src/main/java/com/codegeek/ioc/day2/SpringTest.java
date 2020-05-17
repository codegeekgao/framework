package com.codegeek.ioc.day2;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

@ContextConfiguration(locations = {"classpath:day2/*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testList() {
        MessageSender messageSender = applicationContext.getBean("messageSender1", MessageSender.class);
        System.out.println(messageSender.getList());
    }

    @Test
    public void testSet() {
        MessageSender messageSender = applicationContext.getBean("messageSender2", MessageSender.class);
        System.out.println(messageSender.getSet());
    }

    @Test
    public void testMap() {
        MessageSender messageSender = applicationContext.getBean("messageSender3", MessageSender.class);
        System.out.println(messageSender.getMap());
    }

    @Test
    public void testProps() {
        MessageSender messageSender = applicationContext.getBean("messageSender4", MessageSender.class);
        System.out.println(messageSender.getProperties());
    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("day2/applicationContext.xml");
        MessageSender messageSender = classPathXmlApplicationContext.getBean("messageSender", MessageSender.class);
        messageSender.printMessage();
    }
}
