package com.codegeek.aop.day5.service;


import java.math.BigDecimal;

/**
 * @author CodeGeekGao
 * @version Id: ProductService.java, v 1.0 2020/7/11 10:58 AM CodeGeekGao
 */
public interface ProductService {

    /**
     * 根据产品的名称查询价格
     * @param productName productName
     * @return Product
     */
    Product findProductPrice(String productName);
}
