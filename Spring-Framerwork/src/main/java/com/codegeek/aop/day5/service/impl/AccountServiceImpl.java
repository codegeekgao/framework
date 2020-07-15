package com.codegeek.aop.day5.service.impl;

import com.codegeek.aop.day5.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author CodeGeekGao
 * @version Id: AccountServiceImpl.java, v 1.0 2020/7/11 10:59 AM CodeGeekGao
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据账户名称修改余额
     * @param accountName accountName
     * @param price price
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void updateBalance(String accountName, BigDecimal price) {
        String sql= "update t_account set balance=balance-? where account_name=?";
        jdbcTemplate.update(sql,price,accountName);
    }

    @Override
    public BigDecimal findAccountBalance(String accountName) {
        String sql ="select balance from t_account where account_name =?";
        return jdbcTemplate.queryForObject(sql,BigDecimal.class,accountName);
    }
}
