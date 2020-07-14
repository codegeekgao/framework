package com.codegeek.aop.day5.service;

/**
 * @author CodeGeekGao
 * @version Id: StorageService.java, v 1.0 2020/7/11 11:12 AM CodeGeekGao
 */
public interface StorageService {

    /**
     * 减库存
     * @param id id
     * @param number number
     */
    void decreaseStorage(Integer id,Long number);

    /**
     * 查询库存
     * @param id
     * @return
     */
    Integer storageNumberCount(Integer id);
}
