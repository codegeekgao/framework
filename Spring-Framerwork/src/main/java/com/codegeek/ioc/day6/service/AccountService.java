package com.codegeek.ioc.day6.service;

import com.codegeek.ioc.day6.model.Product;

import java.math.BigDecimal;

/**
 * @author CodeGeekGao
 * @version Id: AccountService.java, v 1.0 2020/6/30 11:59 PM CodeGeekGao
 */
public interface AccountService {



    String buy( String productName,Integer buyCount,String user);
}
