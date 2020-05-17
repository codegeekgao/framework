package com.codegeek.ioc.day1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Phone {

    private String brandName;
    private Double price;
    private String producePlace;

    public Phone() {

    }

}
