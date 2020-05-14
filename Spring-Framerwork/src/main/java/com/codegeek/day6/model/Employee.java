package com.codegeek.day6.model;

import com.codegeek.day6.model.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_employee")
public class Employee {
    @Column(name = "t_name")
    private String name;
    @Column(name = "t_salary")
    private Double salary;
    @Column(name = "t_phoneNumber")
    private Integer phoneNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_employee_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "t_company_id")
    @JsonBackReference
    private Company company;
    @Column(name="t_gender")
    private String gender;
}
