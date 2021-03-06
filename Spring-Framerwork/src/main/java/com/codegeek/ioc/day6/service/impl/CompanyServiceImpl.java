package com.codegeek.ioc.day6.service.impl;

import com.codegeek.ioc.day6.dao.CompanyDao;
import com.codegeek.ioc.day6.model.Company;
import com.codegeek.ioc.day6.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public void save(Company company) {
        companyDao.save(company);
    }
}
