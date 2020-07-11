package com.codegeek.ioc.day6.dao;

import com.codegeek.ioc.day6.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author CodeGeekGao
 * @version Id: ProductDao.java, v 1.0 2020/7/1 12:08 PM CodeGeekGao
 */
@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {

    Product findPriceByProductName(String productName) throws Exception;
}
