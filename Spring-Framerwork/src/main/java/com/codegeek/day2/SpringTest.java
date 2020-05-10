package com.codegeek.day2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("day2/applicationContext.xml");
        MessageSender messageSender = classPathXmlApplicationContext.getBean("messageSender", MessageSender.class);
        messageSender.printMessage();
    }
}
