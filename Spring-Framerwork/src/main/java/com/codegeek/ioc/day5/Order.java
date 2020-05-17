package com.codegeek.ioc.day5;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Order {

    private String orderName;

    private Double price;


    public Order() {
        System.out.println("order被创建了");
    }

    public void  init() {
        System.out.println("order的init方法");
    }

    public void destroy() {
        System.out.println("order的destroy方法");
    }
}
