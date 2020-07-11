package com.codegeek.ioc.day6.model;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(name = "product_name")
    private String productName;
    @Column
    private BigDecimal price;
    @OneToOne
    @JoinColumn(name = "t_storage_id")
    private Storage storage;

}
