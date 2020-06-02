package com.codegeek.aop.day1;

import com.codegeek.aop.day3.pointcut.AdviceRequired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    @AdviceRequired
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public double divide(int a, int b) {
        return a / b;
    }
}
