package com.codegeek.day7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:day7/*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AnnotationDemo {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testRequired() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ApplicationConfiguration.class);
        annotationConfigApplicationContext.refresh();
        Grade bean = annotationConfigApplicationContext.getBean("grade2", Grade.class);
        System.out.println("\n" + bean);
    }


    @Test
    public void testContext() {
        Student student = applicationContext.getBean(Student.class);
        Student student1 = applicationContext.getBean(Student.class);
        System.out.println("\n" + "student= " + student);
        System.out.println(student == student1);

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ApplicationConfiguration.class);
        annotationConfigApplicationContext.refresh();
        Student bean = annotationConfigApplicationContext.getBean(Student.class);
        Student bean1 = annotationConfigApplicationContext.getBean(Student.class);
        System.out.println("bean= "+bean);
        System.out.println(bean1 == bean);

        System.out.println(student == bean);

    }
}
