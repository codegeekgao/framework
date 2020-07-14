package com.codegeek.ioc.day6.service.impl;

import com.codegeek.ioc.day6.dao.AccountDao;
import com.codegeek.ioc.day6.dao.ProductDao;
import com.codegeek.ioc.day6.dao.StorageDao;
import com.codegeek.ioc.day6.model.Product;
import com.codegeek.ioc.day6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author CodeGeekGao
 * @version Id: AccountServiceImpl.java, v 1.0 2020/7/1 12:00 AM CodeGeekGao
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Autowired
    private ProductDao productDao;

    @Autowired
    private StorageDao storageDao;

    /**
     * 案1.例如service层处理事务，那么service中的方法中不做异常捕获，或者在catch语句中最后增加throw new
     *
     * RuntimeException()语句，以便让aop捕获异常再去回滚，并且在service上层（webservice客户端，view层action）要继续捕获
     * 如果捕获了该异常而没有抛出新的异常那么Spring的事务将不会起作用，这里所以需要手动抛出异常
     */
    @Override
    @Transactional
    public String buy(String productName, Integer buyCount, String user) {
        try {
            Product product = productDao.findPriceByProductName(productName);
            accountDao.updateBalance(user,BigDecimal.valueOf(buyCount).multiply(product.getPrice()));
            System.out.println(1/0);
            storageDao.updateStorage(product.getStorage().getId(),buyCount);
        } catch (Exception e) {
            e.printStackTrace();
           throw new RuntimeException(e);
        }
        return "SUCCESS";
    }
}
