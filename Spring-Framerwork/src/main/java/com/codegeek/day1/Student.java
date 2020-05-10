package com.codegeek.day1;

import lombok.Data;

@Data
public class Student {

    private String name;

    private Integer age;

    private String gender;

    private String address;

    private Phone phone;

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Student(Phone phone) {
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("address 被设置了");
        this.address = address;
    }

    public Student() {
        System.out.println("Student.... 空参");
    }

    public Student(String name, Integer age, String address) {
        System.out.println("Student.... 有参");
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(String name, Integer age, String address, String gender) {
        System.out.println("Student.... 有参");
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }
}
