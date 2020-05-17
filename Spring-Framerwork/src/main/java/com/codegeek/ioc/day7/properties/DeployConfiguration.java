package com.codegeek.ioc.day7.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeployConfiguration {

    private String deployUrl;
    private String deployUser;
    private String deployPath;
    private String deployEnvironment;
}
