package com.services.micro.template.demo.resource;

import com.services.micro.commons.logging.annotation.LogExecutionTime;
import com.services.micro.template.demo.api.request.ServiceRequest;
import com.services.micro.template.demo.api.response.ServiceResponse;
import com.services.micro.template.demo.bl.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/")
public class ServiceResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceResource.class);

    @Autowired
    private MyService myService;


//    private RestTemplate restTemplate;

//    @Autowired
//    public void setRestTemplate(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    @GetMapping
    @LogExecutionTime
    public ServiceResponse getMessage() {
        LOGGER.info("getMessage called");
        return myService.getResponse("testkey11111333");
    }

    @GetMapping(value = "/plain")
    @LogExecutionTime
    public String helloWorlda() {
        return myService.getResponse("test").getMessage();
    }

    @GetMapping(value = "/hello")
    @LogExecutionTime
    public String getHello(String key1, String key2) {
        return "hello " + key1 + "  " + key2;
    }

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @LogExecutionTime
    public ServiceResponse post(@RequestBody ServiceRequest serviceRequest) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setMessage("Hello " + serviceRequest.getInput());
        serviceResponse.setType("post");
        return serviceResponse;
    }

    @GetMapping(value = "/test")
    @Cacheable(cacheNames = "default")
    public String test(String key) {
        LOGGER.info("Called test method inside .... ");
        return "Hello " + key;
    }

    @GetMapping(value = "/test1")
    @Cacheable(cacheNames = "default1")
    public String test1(String key) {
        LOGGER.info("Called test1 method inside .... ");
        return "Hello " + key;
    }
}


