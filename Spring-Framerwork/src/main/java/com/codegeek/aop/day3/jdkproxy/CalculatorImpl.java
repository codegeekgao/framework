package com.codegeek.aop.day3.jdkproxy;

import org.springframework.stereotype.Service;



@Service(value = "calculator")
public class CalculatorImpl implements Calculator {
    @Override
    public Double divide(Double a, Double b) {
        return a / b;
    }
}
