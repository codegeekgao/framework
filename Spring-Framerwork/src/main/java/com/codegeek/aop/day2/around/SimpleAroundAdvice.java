package com.codegeek.aop.day2.around;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.util.Arrays;


public class SimpleAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("\n" + "around...before...advice...start");
        StopWatch stopWatch = new StopWatch();
        System.out.println("切点表达式：" + invocation.getStaticPart());
        System.out.println("开始计时类:" + invocation.getThis() + "的" + invocation.getMethod().getName() + "方法");
        stopWatch.start(invocation.getMethod().getName());
        // 执行方法
        Object proceed = invocation.proceed();
        System.out.println("共打印了" + Arrays.stream(invocation.getArguments()).findFirst().get() + "次");
        stopWatch.stop();
        System.out.println("执行任务共耗时：" + stopWatch.getTotalTimeSeconds());
        System.out.println("around...before...advice...end");
        return proceed;
    }
}
