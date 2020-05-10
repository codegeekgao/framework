package com.codegeek.day1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("day1/applicationContext.xml");
        Student student1 = applicationContext.getBean("student4", Student.class);
        System.out.println(student1);

    }
}
