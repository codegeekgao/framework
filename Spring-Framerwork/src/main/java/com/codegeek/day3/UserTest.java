package com.codegeek.day3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:day3/*.xml"})
public class UserTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testP() {
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void testParent() {
        User user1 = applicationContext.getBean("user1", User.class);
        User user2 = applicationContext.getBean("user1", User.class);
        System.out.println(user1 == user2);
    }
}
