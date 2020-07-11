package com.codegeek.ioc.day6.dao;

import com.codegeek.ioc.day6.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author CodeGeekGao
 * @version Id: StorageDao.java, v 1.0 2020/7/1 10:36 PM CodeGeekGao
 */
@Repository
public interface StorageDao extends JpaRepository<Storage,Integer> {

    @Modifying
    @Transactional
    @Query(value = "update t_storage1  set storage_number=storage_number-:storageNumber where id=:id",nativeQuery = true)
    void updateStorage(@Param("id") Integer id, @Param("storageNumber") Integer storageNumber) throws Exception;

}
