package com.codegeek.aop.day2.methodbefore;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public String getEmployeeName(int type) {
        if(type==1) return "经理";
        if(type==0) return "普通员工";
        return null;
    }
}
