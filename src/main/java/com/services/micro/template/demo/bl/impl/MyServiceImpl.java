package com.services.micro.template.demo.bl.impl;


import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.services.micro.template.demo.api.response.ServiceResponse;
import com.services.micro.template.demo.bl.MyService;
import com.services.micro.template.demo.config.MyConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service(value = "MyService")
@EnableConfigurationProperties(MyConfigurationProperties.class)
public class MyServiceImpl implements MyService {

    @Autowired
    private MyConfigurationProperties myConfigurationProperties;

    @Value("${service.myKey1}")
    private String myKey1;

    @Override
    @Timed
    @ExceptionMetered
    @HystrixCommand(groupKey = "hystrixGroup", commandKey = "helloCommandKey", threadPoolKey = "helloThreadPoolKey", fallbackMethod = "fallbackHello")
    @Cacheable(cacheNames = "default")
    public ServiceResponse getResponse(String key) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setMessage("Hello " + key + myConfigurationProperties.getMyKey1() + "  key1 is " + myKey1);
        serviceResponse.setType("valid");
        return serviceResponse;
    }

    public ServiceResponse fallbackHello(String name) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setMessage("This is Hello fromm fallback " + name);
        return serviceResponse;
    }
}
