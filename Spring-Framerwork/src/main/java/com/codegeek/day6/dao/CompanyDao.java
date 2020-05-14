package com.codegeek.day6.dao;

import com.codegeek.day6.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao  extends JpaRepository<Company, Integer> {
}
