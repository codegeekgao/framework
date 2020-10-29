package com.codegeek.ioc.day6.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.codegeek.ioc.day6.model.ExportMessage;
import com.codegeek.ioc.day6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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


    @RequestMapping("/channel/exportMessage")
    @ResponseBody

    public void importTrades(HttpServletResponse response) throws Exception {

        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        List<ExportMessage> list = new ArrayList<>();
        list.add(new ExportMessage("1111"));
        EasyExcel.write(response.getOutputStream(), ExportMessage.class).sheet("模板").doWrite(list);
    }

}
