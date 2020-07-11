package com.codegeek.ioc.day6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 账户表
 *
 * @author CodeGeekGao
 * @version Id: Account.java, v 1.0 2020/6/29 11:29 PM CodeGeekGao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "account_name")
    private String accountName;
    @Column
    private BigDecimal balance;
}
