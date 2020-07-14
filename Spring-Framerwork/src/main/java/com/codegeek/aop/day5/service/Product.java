package com.codegeek.aop.day5.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 产品
 *
 * @author CodeGeekGao
 * @version Id: Product.java, v 1.0 2020/6/29 11:32 PM CodeGeekGao
 */
@Data
public class Product {

    private Integer id;
    private String productName;
    private BigDecimal price;
    private Integer storageId;

}
