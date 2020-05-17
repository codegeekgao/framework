package com.codegeek.ioc.day7.profile;

import com.mysql.jdbc.Driver;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Profile(value = "dev")
public class DevConfiguration {

    @Bean(name = "dataSource")
    public DataSource createDataSource(@Qualifier("dataConfig") DataConfig config) throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(config.getUrl());
        dataSource.setDriver(config.getDriver());
        dataSource.setUsername(config.getUserName());
        dataSource.setPassword(config.getPassword());
        return dataSource;
    }

    @Bean(name = "dataConfig")
    public DataConfig devData() throws SQLException {
        String url = "jdbc:mysql://localhost/test?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8&autoReconnect=true";
        Driver driver = new Driver();
        String userName = "root";
        String password = "123456";
        return new DataConfig(driver, url, userName, password);
    }
}
