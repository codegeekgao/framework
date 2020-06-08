package com.codegeek.aop.day3.pointcut.composable.service;

import com.codegeek.aop.day3.pointcut.composable.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private static List<Product> PRODUCT_LIST = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        PRODUCT_LIST.add(product);
        log.info("添加产品成功，产品信息：{}",product);
    }

    @Override
    public void deleteProduct(Product product) {
        PRODUCT_LIST.remove(product);
        log.info("删除产品成功，产品信息：{}",product);
    }

    @Override
    public List<Product> findAllProduct() {
        return PRODUCT_LIST;
    }

    @Override
    public List<Product> findProductByProductName(String productName) {
        return PRODUCT_LIST.stream().filter(e-> e.getProductName().equals(productName)).collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductByProductAddress(String address) {
        return  PRODUCT_LIST.stream().filter(e-> e.getProductAddress().equals(address)).collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductByProductCompany(String company) {
        return  PRODUCT_LIST.stream().filter(e-> e.getProduceCompany().equals(company)).collect(Collectors.toList());
    }
}
