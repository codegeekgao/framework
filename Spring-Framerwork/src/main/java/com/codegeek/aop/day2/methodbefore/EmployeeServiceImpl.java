package com.codegeek.aop.day2.methodbefore;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public String getEmployeeName(int type) {
        System.out.println("\n" + "开始执行getEmployeeName方法.......");
        if (type == 1) return "经理";
        if (type == 0) return "普通员工";
        return null;
    }
}
