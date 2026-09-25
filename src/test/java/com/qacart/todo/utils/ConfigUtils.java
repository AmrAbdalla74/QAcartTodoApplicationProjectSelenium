package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {

    private Properties properties;

    private static ConfigUtils configUtils;

    private  ConfigUtils(){
        properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
    }

    public static ConfigUtils getInstance(){
        if (configUtils == null){
            configUtils =  new ConfigUtils();
        }
        return configUtils ;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        throw new RuntimeException("Could not fine the base url in the property file");
    }

    public String getEmail(){
        String prop = properties.getProperty("email");
        if (prop != null) return prop;
        throw new RuntimeException("Could not fine the email in the property file");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        throw new RuntimeException("Could not fine password in the property file");
    }
}
