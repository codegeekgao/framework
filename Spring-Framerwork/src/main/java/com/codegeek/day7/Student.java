package com.codegeek.day7;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
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
