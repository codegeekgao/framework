package com.codegeek.ioc.day3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {

    private String userName;

    private String email;

    private Integer age;

}
