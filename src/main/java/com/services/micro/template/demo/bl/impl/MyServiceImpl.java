package com.services.micro.template.demo.bl.impl;


import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.services.micro.template.demo.api.response.ServiceResponse;
import com.services.micro.template.demo.bl.MyService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service(value = "MyService")
public class MyServiceImpl implements MyService {

    @Override
    @Timed
    @ExceptionMetered
    @HystrixCommand(groupKey = "hystrixGroup", commandKey = "helloCommandKey", threadPoolKey = "helloThreadPoolKey", fallbackMethod = "fallbackHello")
    @Cacheable(cacheNames = "default")
    public ServiceResponse getResponse(String key) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setMessage("Hello " + key);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serviceResponse;
    }

    public ServiceResponse fallbackHello(String name) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setMessage("This is Hello fromm fallback " + name);
        return serviceResponse;
    }
}
