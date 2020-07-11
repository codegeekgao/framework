package com.codegeek.ioc.day6.service;

import com.codegeek.ioc.day6.model.Storage;

/**
 * @author CodeGeekGao
 * @version Id: StorageService.java, v 1.0 2020/7/2 8:21 PM CodeGeekGao
 */
public interface StorageService {

    void reduceStorageNumber(Integer storageId,Integer buyCount) throws Exception;
}
