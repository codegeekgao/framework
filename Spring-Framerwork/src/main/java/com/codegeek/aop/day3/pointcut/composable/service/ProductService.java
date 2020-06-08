package com.codegeek.aop.day3.pointcut.composable.service;

import com.codegeek.aop.day3.pointcut.composable.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    void deleteProduct(Product product);

    List<Product> findAllProduct();

    List<Product> findProductByProductName(String productName);

    List<Product> findProductByProductAddress(String address);

    List<Product> findProductByProductCompany(String company);

}
