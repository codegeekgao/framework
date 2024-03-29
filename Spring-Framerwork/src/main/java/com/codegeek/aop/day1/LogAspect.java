package com.codegeek.aop.day1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Aspect
@Component
public class LogAspect {

    /**
     * 定义切点，其中execution定义切入点表达式
     */
    @Pointcut(value = "execution(* *..aop..*(..))")
    public void logPoint() {

    }
    /**
     * 前置通知在方法执行前执行
     */
    @Before(value = "execution(public * com.codegeek.aop.day1.CalculatorImpl.*(..))")
    public static void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        // 拿到执行方法的源对象-----即切入表达式实际切入的地方并运行的地方
        System.out.println(joinPoint.getTarget().getClass());
        //  System.out.println(joinPoint.getStaticPart()); 打印详细切入点表达式

        System.out.println("LogAspect-普通通知方法@before：" + joinPoint.getSignature().getName() + "日志开始了....方法参数：" + Arrays.asList(args));
    }

    /**
     * 方法执行后返回结果后执行该通知
     * @param result
     */
    @AfterReturning(value = "execution(public * com.codegeek.aop.day1.CalculatorImpl.*(..))", returning = "result")
    public static void logRun(Object result) {
        System.out.println("LogAspect-普通通知@AfterReturning" + "运行结果为：" + result);
    }

    /**
     *
     * 如果方法执行出现异常将执行此通知
     */
    @AfterThrowing(value = "execution(public  * com.codegeek.aop.day1.Calculator.*(..))", throwing = "e")
    public static void logException(Exception e) {
        System.out.println("LogAspect-普通通知@AfterThrowing出异常啦:" + e);
    }

    /**
     * 后置通知切入点执行后
     */
    @After(value = "execution(public  * com.codegeek.aop.day1.Calculator.*(..))")
    public void logEnd() {
        System.out.println("LogAspect-普通通知@After日志结束了");
    }

    @Around(value = "logPoint()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) {
        Object proceed = null;
        try {
            // @Before
            System.out.println("环绕前通知.....当前执行的方法：" + proceedingJoinPoint.getSignature().getName());
            proceed = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            // @AfterReturn
            System.out.println("环绕后通知.....");
        } catch (Throwable throwable) {
            // @AfterThrowing
            System.out.println("环绕异常通知.......");
            // 如果不抛出异常----则就将异常catch掉了，普通通知异常将无法感知到异常对象，所以认为是正常执行的
           throw new RuntimeException(throwable);

        } finally {
            // @After
            System.out.println("环绕结束通知.....");
        }
        return proceed;
    }
}
