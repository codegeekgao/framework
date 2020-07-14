package com.codegeek.aop.day5.service;

import java.math.BigDecimal;

/**
 * @author CodeGeekGao
 * @version Id: AccountService.java, v 1.0 2020/7/11 10:58 AM CodeGeekGao
 */
public interface AccountService {

    /**
     * 根据账户名称修改余额
     * @param accountName accountName
     * @param price price
     */
    public void updateBalance(String accountName, BigDecimal price);

    /**
     * 根据账户名称查询账户余额
     * @param accountName accountName
     * @return BigDecimal 余额
     */
    BigDecimal findAccountBalance(String accountName);
}
