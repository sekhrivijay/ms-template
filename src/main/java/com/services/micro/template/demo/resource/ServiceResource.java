package com.services.micro.template.demo.resource;

import com.services.micro.template.demo.api.request.ServiceRequest;
import com.services.micro.template.demo.api.response.ServiceResponse;
import com.services.micro.template.demo.bl.MyService;
import com.services.micro.template.demo.bl.impl.MyServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/test")
public class ServiceResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceResource.class);

    @Autowired
    private MyService myService;

    @GetMapping
    public ServiceResponse getMessage() {
        LOGGER.info("getMessage called");
        return myService.getResponse("testkey");
    }

    @GetMapping(value = "/plain")
    public String helloWorlda() {
        return myService.getResponse("test").getMessage();
    }

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponse post(@RequestBody ServiceRequest serviceRequest) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setMessage("Hello " + serviceRequest.getInput());
        serviceResponse.setType("post");
        return serviceResponse;
    }

}


