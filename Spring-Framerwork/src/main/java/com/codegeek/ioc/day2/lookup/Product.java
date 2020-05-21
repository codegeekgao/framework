package com.codegeek.ioc.day2.lookup;

import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
public class Product {

    private String productName;

    private String productPrice;

    private String productAddress;
}
