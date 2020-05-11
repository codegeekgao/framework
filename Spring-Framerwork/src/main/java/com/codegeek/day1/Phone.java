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

    public static Phone instance(String brandName,Double price,String producePlace) {
        return new Phone(brandName,price,producePlace);
    }

    public Phone getPhone() {
        return new Phone();
    }
}
