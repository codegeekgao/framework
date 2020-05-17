package com.codegeek.ioc.day7.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:day7/customize.properties")
public class PropertySourceConfiguration {

    @Autowired
    private Environment environment;

    @Bean(name = "deployConfiguration")
    public DeployConfiguration create() {
        DeployConfiguration configuration = new DeployConfiguration();
        configuration.setDeployEnvironment(environment.getProperty("deploy.environment"));
        configuration.setDeployPath(environment.getProperty("deploy.path"));
        configuration.setDeployUrl(environment.getProperty("deploy.url"));
        configuration.setDeployUser(environment.getProperty("deploy.user"));
        return configuration;
    }
}
