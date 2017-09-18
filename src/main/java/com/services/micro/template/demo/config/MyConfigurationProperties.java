package com.services.micro.template.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix = "service")
@EnableConfigurationProperties
public class MyConfigurationProperties {
    private String myKey1;
    private String myKey2;

    public String getMyKey1() {
        return myKey1;
    }

    public void setMyKey1(String myKey1) {
        this.myKey1 = myKey1;
    }

    public String getMyKey2() {
        return myKey2;
    }

    public void setMyKey2(String myKey2) {
        this.myKey2 = myKey2;
    }
}
