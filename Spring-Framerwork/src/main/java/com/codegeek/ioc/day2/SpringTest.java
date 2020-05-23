package com.codegeek.ioc.day2;

import com.codegeek.ioc.day2.lookup.AbstractFactory;
import com.codegeek.ioc.day2.replacemethod.UserService;
import com.codegeek.ioc.day2.replacemethod.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

@ContextConfiguration(locations = {"classpath:ioc/day2/*.xml"})
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
    @Test
    public void testLookup() {
        // 获取工厂
        System.out.println();
        AbstractFactory bean = (AbstractFactory) applicationContext.getBean(AbstractFactory.class);
        // 调用生产产品的方法
        bean.createProduct();
    }
    @Test
    public void testReplaceMethod() {
        UserService bean = applicationContext.getBean("userService",UserServiceImpl.class);
        bean.findUserNameById("1");
    }



    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("ioc/day2/applicationContext.xml");
        MessageSender messageSender = classPathXmlApplicationContext.getBean("messageSender", MessageSender.class);
        messageSender.printMessage();
    }
}
