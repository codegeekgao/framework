package com.codegeek.day7;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.codegeek.day7")
@Import(DataConfiguration.class)
@ImportResource(locations = {"classpath:day7/annotationContext.xml"})
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
