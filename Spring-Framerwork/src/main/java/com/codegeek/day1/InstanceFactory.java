package com.codegeek.day1;


public class InstanceFactory {


    public static Phone instance(String brandName, Double price, String producePlace) {
        return new Phone(brandName,price,producePlace);
    }


    public Phone getPhone(String brandName,Double price,String producePlace) {
        return new Phone(brandName,price,producePlace);
    }
}
