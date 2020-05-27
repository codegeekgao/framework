package com.codegeek.aop.day2.throwexception;

import org.springframework.stereotype.Service;

@Service
public class CalculateImpl implements CalculateService {
    @Override
    public int divide(int a, int b) {
        return a / b;
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
