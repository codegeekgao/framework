package com.codegeek.ioc.day6.controller;

import com.codegeek.ioc.day6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author CodeGeekGao
 * @version Id: AccountController.java, v 1.0 2020/7/1 12:15 AM CodeGeekGao
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    public ResponseEntity<String> buyProduct(@RequestParam String productName,@RequestParam Integer buyCount,@RequestParam String user) {
        return  ResponseEntity.ok( accountService.buy(productName,buyCount,user));
    }
}
