package com.codegeek.aop.day3.pointcut.composable;

import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

public class AddMethodMatcher extends StaticMethodMatcher {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        String methodName = method.getName();
        return methodName.startsWith("add");
    }
}

class DeleteMethodMatcher extends StaticMethodMatcher {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        String name = method.getName();
        return name.contains("delete") || name.endsWith("Name") ;
    }
}


class FindMethodMatcher extends StaticMethodMatcher {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.getName().contains("find");
    }
}