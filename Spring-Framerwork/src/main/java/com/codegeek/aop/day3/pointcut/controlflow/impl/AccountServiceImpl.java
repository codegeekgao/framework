package com.codegeek.aop.day3.pointcut.controlflow.impl;

import com.codegeek.aop.day3.pointcut.controlflow.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {


    @Override
    public void updateBalanceAndExpress() {
        System.out.println("updateBalanceAndExpress 执行成功");
    }
}
