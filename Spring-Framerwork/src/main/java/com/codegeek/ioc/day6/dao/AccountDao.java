package com.codegeek.ioc.day6.dao;

import com.codegeek.ioc.day6.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author CodeGeekGao
 * @version Id: AccountDao.java, v 1.0 2020/7/1 12:01 AM CodeGeekGao
 */
@Repository
public interface AccountDao extends JpaRepository<Account,Integer> {

    @Modifying
    @Transactional
    @Query(value = "update t_account set balance= balance-:balance where account_name=:userName ",nativeQuery = true)
    int updateBalance(@Param("userName") String userName, @Param("balance") BigDecimal balance) throws Exception;
}
