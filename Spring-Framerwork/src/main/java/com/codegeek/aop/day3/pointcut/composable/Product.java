package com.codegeek.aop.day3.pointcut.composable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String productName;
    private String productAddress;
    private BigDecimal productPrice;
    private String category;
    private String produceCompany;
}
