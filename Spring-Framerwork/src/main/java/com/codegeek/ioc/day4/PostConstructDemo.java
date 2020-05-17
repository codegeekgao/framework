package com.codegeek.ioc.day4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PostConstructDemo {

    @PostConstruct
    public void init() {
        System.out.println("---我是postConstruct注解的init方法");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("---我是preDestroy注解的destroy方法");
    }
}
