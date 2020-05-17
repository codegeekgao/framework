package com.codegeek.ioc.day7.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Driver;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataConfig {
    private Driver driver;
    private String url;
    private String userName;
    private String password;
}
