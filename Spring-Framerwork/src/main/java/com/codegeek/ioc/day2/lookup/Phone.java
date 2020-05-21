package com.codegeek.ioc.day2.lookup;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Phone extends Product {
    public Phone() {
        System.out.println("生产的是手机");
    }
}
