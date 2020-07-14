package com.codegeek.aop.day5.service.impl;

import com.codegeek.aop.day5.service.Product;
import com.codegeek.aop.day5.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author CodeGeekGao
 * @version Id: ProductServiceImpl.java, v 1.0 2020/7/11 11:05 AM CodeGeekGao
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据产品的名称查询价格
     * @param productName productName
     * @return Product
     */
    @Override
    public Product findProductPrice(String productName) {
        String sql ="select * from t_product where product_name=?";
        List<Product> query = jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setProductName(resultSet.getString("product_name"));
                product.setStorageId(resultSet.getInt("t_storage_id"));
                return product;
            }
        }, productName);
        return query.get(0);
    }
}
