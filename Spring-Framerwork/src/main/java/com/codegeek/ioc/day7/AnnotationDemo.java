package com.codegeek.ioc.day7;

import com.codegeek.ioc.day7.profile.DataConfig;
import com.codegeek.ioc.day7.properties.DeployConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:ioc/day7/*.xml")
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
        System.out.println("bean= " + bean);
        System.out.println(bean1 == bean);

        System.out.println(student == bean);

    }

    @Test
    public void profile() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("dev");
        applicationContext.register(ApplicationConfiguration.class);
        applicationContext.refresh();
        DataConfig dataConfig = applicationContext.getBean("dataConfig", DataConfig.class);
        System.out.println("\n" + dataConfig);
    }

    @Test
    public void testPropertySource() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        DeployConfiguration configuration = applicationContext.getBean("deployConfiguration", DeployConfiguration.class);
        System.out.println("\n"+configuration);
    }
}
