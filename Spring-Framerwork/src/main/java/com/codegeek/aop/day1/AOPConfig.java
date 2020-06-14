package com.codegeek.aop.day1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP配置
 * @author CodeGeekGao
 * @version Id: AOPConfig.java, v 1.0 2020/6/14 12:16 PM CodeGeekGao
 */
@Configuration
@ComponentScan(basePackages = {"com.codegeek.aop.day1"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AOPConfig {

}
