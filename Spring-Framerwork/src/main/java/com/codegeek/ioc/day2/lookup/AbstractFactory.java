package com.codegeek.ioc.day2.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
@Component
public  abstract class AbstractFactory {

    @Lookup("computer")
    public abstract Product createProduct();
}
