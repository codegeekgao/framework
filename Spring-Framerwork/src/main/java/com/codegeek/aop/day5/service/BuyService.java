package com.codegeek.aop.day5.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author CodeGeekGao
 * @version Id: BuyService.java, v 1.0 2020/7/11 11:17 AM CodeGeekGao
 */
public interface BuyService {

    void buy(String userName,String productName,Long buyCount) throws Exception;
}
