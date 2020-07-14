package com.codegeek.aop.day5.service;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 账户表
 *
 * @author CodeGeekGao
 * @version Id: Account.java, v 1.0 2020/6/29 11:29 PM CodeGeekGao
 */
@Data
public class Account {

    private Integer id;
    private String accountName;
    private BigDecimal balance;
}
