package com.codegeek.ioc.day6.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_company")
public class Company {
    @Column(name = "t_companyName")
    private String companyName;

    @Column(name = "t_createTime")
    private Date createTime;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Employee> employees;
    @Column(name = "t_companyAddress")
    private String companyAddress;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_company_id")
    private Integer id;

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Company company = new Company();
        company.setCompanyName("google");
        company.setCompanyAddress("America");
        company.setCreateTime(new Date());

        Employee employee1 = new Employee();
        employee1.setCompany(company);
        employee1.setGender("男");
        employee1.setName("张三");
        employee1.setPhoneNumber(123456789);
        employee1.setSalary(5000d);
        employee1.setCompany(company);

        Employee employee2 = new Employee();
        employee2.setCompany(company);
        employee2.setGender("女");
        employee2.setName("小红");
        employee2.setPhoneNumber(987452621);
        employee2.setSalary(9000d);
        employee2.setCompany(company);

        company.setEmployees(Arrays.asList(employee1,employee2));
        // key为null的元素不进行序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String s = objectMapper.writeValueAsString(company);
        System.out.println(s);
        // TODO 循环数据如何进行读取？
        Company value = objectMapper.readValue(s, Company.class);
        System.out.println(value);
    }

}
