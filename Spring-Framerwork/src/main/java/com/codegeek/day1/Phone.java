package com.codegeek.day1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Phone {

    private String brandName;
    private Double price;
    private String producePlace;


    private Phone() {
    }

    public static Phone instance() {
        return new Phone();
    }

    public Phone getPhone() {
        return new Phone();
    }
}
