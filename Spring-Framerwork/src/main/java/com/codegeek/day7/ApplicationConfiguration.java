package com.codegeek.day7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfiguration {

    @Bean(name = "student2")
    public Student createStudent() {
        return new Student("张三", 23);
    }

    @Primary
    @Bean(name = "student3")
    public Student createStudent1() {
        return new Student("李四", 24);
    }


}
