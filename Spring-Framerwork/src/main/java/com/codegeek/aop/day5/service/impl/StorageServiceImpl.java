package com.codegeek.aop.day5.service.impl;

import com.codegeek.aop.day5.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author CodeGeekGao
 * @version Id: StorageServiceImpl.java, v 1.0 2020/7/11 11:14 AM CodeGeekGao
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 减库存
     * @param id id
     * @param number number
     */
    @Override
    @Transactional(propagation = Propagation.NESTED,rollbackFor = Exception.class)
    public void decreaseStorage(Integer id, Long number) {
        String sql="update t_storage  set storage_number=storage_number-? where id=?";
        jdbcTemplate.update(sql,number,id);
    }

    /**
     * 查询库存
     * @param id
     * @return
     */
    @Override
    public Integer storageNumberCount(Integer id) {
        String sql="select storage_number from t_storage where id=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,id);
    }
}
