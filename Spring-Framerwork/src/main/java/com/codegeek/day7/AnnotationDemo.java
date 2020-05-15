package com.codegeek.day7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:day7/*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AnnotationDemo {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testRequired() {
        Student student = applicationContext.getBean( Student.class);
        System.out.println("\n"+student);
    }
}
