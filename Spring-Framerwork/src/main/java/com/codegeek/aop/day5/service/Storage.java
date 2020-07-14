package com.codegeek.aop.day5.service;

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

public class Storage {

    private Integer id;

    private Integer storageNumber;

    private Product product;
}
