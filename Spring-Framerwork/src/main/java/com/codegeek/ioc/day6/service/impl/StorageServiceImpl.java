package com.codegeek.ioc.day6.service.impl;

import com.codegeek.ioc.day6.dao.StorageDao;
import com.codegeek.ioc.day6.model.Storage;
import com.codegeek.ioc.day6.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author CodeGeekGao
 * @version Id: StorageServiceImpl.java, v 1.0 2020/7/2 8:23 PM CodeGeekGao
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    @Transactional
    public void reduceStorageNumber(Integer storageId,Integer buyCount) throws Exception{
        System.out.println(1/0);
        storageDao.updateStorage(storageId,buyCount);
    }
}
