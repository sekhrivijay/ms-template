package com.services.micro.template.demo.resource;

import com.services.micro.template.demo.api.response.ServiceResponse;
import com.services.micro.template.demo.bl.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ServiceResource {

    @Autowired
    private MyService myService;


    @RequestMapping("/test")
    public ServiceResponse getMessage(){
        return myService.getResponse("testkey" + System.nanoTime());
    }
}
