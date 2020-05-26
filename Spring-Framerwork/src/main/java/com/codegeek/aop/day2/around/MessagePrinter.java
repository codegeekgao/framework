package com.codegeek.aop.day2.around;

public class MessagePrinter {


    public void print(int times) {
        for (int i = 0; i < times; i++) {
            System.out.print("*");
        }
    }
}
