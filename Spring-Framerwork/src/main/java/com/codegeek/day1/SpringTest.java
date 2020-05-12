package com.codegeek.day1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = {"classpath:day1/*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("day1/applicationContext.xml");
        Student student1 = applicationContext.getBean("student4", Student.class);
        System.out.println(student1);
    }


    @Test
    public void getPhone() {
        // 实例工厂方法
        Phone phone1 = applicationContext.getBean("phone1", Phone.class);
        System.out.println(phone1);
        // 静态工厂方法
        Phone iphone2 = applicationContext.getBean("iphone2", Phone.class);
        System.out.println(iphone2);
    }
}
