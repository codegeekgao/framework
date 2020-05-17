package com.codegeek.ioc.day4;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;

public class BeanLife implements InitializingBean, DisposableBean {

    @Autowired
    private Account account;

    /**
     * bean销毁的时候可执行的操作
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy() 销毁的操作 .. 执行扣钱的操作");
        this.execute(account, "reduce");
    }

    /***
     * 初始化对象可执行的操作
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet() 初始化对象的操作.....执行账号加钱操作");
        this.execute(account, "add");
    }

    @PostConstruct
    public void init() {
        System.out.println("---我是postConstruct注解的init方法");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("---我是preDestroy注解的destroy方法");
    }


    public void SpringInit() {
        System.out.println("---我是spring调用的init方法");
    }


    public void SpringDestroy() {
        System.out.println("---我是spring调用的destroy方法");
    }


    private void execute(Account account, String method) {
       // System.out.println("-----执行excute--------"+method);
        Assert.state(account != null, "account must not empty!");
        if ("add".equals(method)) {
            account.addBalance(new BigDecimal(50001));
        } else if ("reduce".equals(method)) {
            account.reduceBalance(new BigDecimal(49999));
        }
    }
}
