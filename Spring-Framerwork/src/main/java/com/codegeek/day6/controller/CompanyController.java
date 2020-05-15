package com.codegeek.day6.controller;


import com.codegeek.day6.model.Company;
import com.codegeek.day6.service.CompanyService;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/haha/{say}")
    public String hello(@PathVariable("say") String words) {
        return words;
    }

    @RequestMapping(value = "/saveCompany" )
    public ResponseEntity<String> saveCompany(@RequestBody Company company) {
        companyService.save(company);
        return ResponseEntity.ok("保存成功");
    }

}