package com.codegeek.aop.day5.service.impl;

import com.codegeek.aop.day5.service.*;
import com.codegeek.aop.day5.service.ex.MessageException;
import com.sun.jmx.remote.internal.RMIExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.management.remote.rmi.RMIServer;
import java.io.*;
import java.math.BigDecimal;

/**
 * @author CodeGeekGao
 * @version Id: BuyServiceImpl.java, v 1.0 2020/7/13 3:20 PM CodeGeekGao
 */
@Service
public class BuyServiceImpl implements BuyService {

    @Autowired
    private AccountService accountService;
    @Autowired
    private ProductService productService;
    @Autowired
    private StorageService storageService;

    @Transactional(propagation = Propagation.REQUIRED,timeout = 2, noRollbackFor = MessageException.class,
            rollbackFor = FileNotFoundException.class,readOnly = false)
    public void buy(String userName, String productName, Long buyCount) throws Exception {
        Product productItem = productService.findProductPrice(productName);
        if (productItem == null) throw new RuntimeException("该产品不存在");
        if (storageService.storageNumberCount(productItem.getStorageId()) < buyCount) {
            throw new RuntimeException("该产品库存不足");
        }
        // 根据产品名称计算购买总额
        BigDecimal total = productItem.getPrice().multiply(BigDecimal.valueOf(buyCount));

        if (accountService.findAccountBalance(userName).compareTo(total) < 0) {
            throw new RuntimeException("用户余额不足，无法购买产品");
        }
        // 更新余额
        accountService.updateBalance(userName, total);
        // 减去库存
        storageService.decreaseStorage(productItem.getStorageId(), buyCount);

        System.out.println(1/0);
       // InputStream is = new FileInputStream("xixi");
        // kafka 发送消息通知物流进行商品出货操作
       // sendMessage(userName, productName);
    }

    public void sendMessage(String userName, String productName) {
        // TODO 伪代码模拟发送消息失败
        throw new MessageException("kafka中间件发送消息错误");
    }
}
