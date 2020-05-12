package com.codegeek.day3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.StringJoiner;
@NoArgsConstructor
@Getter
@Setter
public class User extends Person {

    public User(String userName, String email, Integer age) {
        System.out.println("实例化配置"+userName);
       this.setUserName(userName);
       this.setEmail(email);
       this.setAge(age);
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
