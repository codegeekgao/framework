package com.codegeek.ioc.day3;

import lombok.NoArgsConstructor;

import java.util.StringJoiner;

@NoArgsConstructor
public class User extends Person {

    public User(String userName, String email, Integer age) {
        this.setUserName(userName);
        this.setEmail(email);
        this.setAge(age);
       // System.out.println("实例化配置" + this.getUserName());
    }


    @Override
    public void setUserName(String userName) {
        System.out.println("设置了username："+userName);
        super.setUserName(userName);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("userName='" + this.getUserName() + "'")
                .add("email='" + this.getEmail() + "'")
                .add("age=" + this.getAge())
                .toString();
    }
}
