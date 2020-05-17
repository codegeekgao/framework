package com.codegeek.ioc.day5;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertySourcesPlaceholderConfigurer extends
        PropertyPlaceholderConfigurer {

    private String[] encryptPropNames = {"jdbc.username", "jdbc.password"};

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            String decryptValue = DESUtil.getDecryptString(propertyValue);
            System.out.println("解密后的值："+decryptValue);
            return decryptValue;
        } else {
            return propertyValue;
        }
    }

    private boolean isEncryptProp(String propertyName) {
        for (String encryptPropertyName : encryptPropNames) {
            if (encryptPropertyName.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
}
