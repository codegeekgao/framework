package com.codegeek.ioc.day7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {

    @Bean
    public Grade createGrade() {
        return new Grade("大学一年级");
    }
}
