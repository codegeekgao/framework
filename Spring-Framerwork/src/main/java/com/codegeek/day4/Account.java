package com.codegeek.day4;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

    private String userId;
    private String accountId;
    private BigDecimal accountBalance;

    private static final BigDecimal BIG_DECIMAL = new BigDecimal(10);

    public void addBalance(BigDecimal balance) {
        if (this.accountBalance.compareTo(new BigDecimal(10000)) < -1) {
            this.accountBalance = this.accountBalance.add(balance);
            System.out.println("用户:" + userId + " 账号:" + accountId + "入账" + balance + "元");
        }
    }


    public void reduceBalance(BigDecimal balance) {
        if (this.accountBalance.compareTo(new BigDecimal(10000)) > -1) {
            this.accountBalance = this.accountBalance.subtract(balance);
            System.out.println("用户:" + userId + " 账号:" + accountId + "扣款" + balance + "元");
        }
    }
}
