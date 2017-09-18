package com.services.micro.template.demo.bl.impl;


import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.services.micro.template.demo.api.response.ServiceResponse;
import com.services.micro.template.demo.bl.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service(value = "MyService")
public class MyServiceImpl implements MyService{

    @Override
    @Cacheable(cacheNames = "default")
    @Timed
    @ExceptionMetered
    public ServiceResponse getResponse(String key) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setMessage("Hello");
        return serviceResponse;
    }
}
