package com.codegeek.ioc.day6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 库存表
 *
 * @author CodeGeekGao
 * @version Id: Storage.java, v 1.0 2020/6/29 11:34 PM CodeGeekGao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "storage_number")
    private Integer storageNumber;
    @OneToOne(mappedBy = "storage")
    private Product product;
}
