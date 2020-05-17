package com.codegeek.ioc.day7;

import lombok.*;

import javax.annotation.Resource;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private String name;
    private Integer age;

    @Resource(name = "grade2")
    private Grade grade1;


    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
