package com.services.micro.template.demo.hc;

import com.services.micro.template.demo.api.response.ServiceResponse;
import com.services.micro.template.demo.bl.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthCheck  implements HealthIndicator {

    @Autowired
    private MyService myService;


    @Override
    public Health health() {
        ServiceResponse serviceResponse = myService.getResponse("test");
        if (serviceResponse.getMessage().equals("Helalo test")) {
            return Health.up().build();
        }
        return Health
                .down()
                .withDetail("Error Code", 1)
                .withException(new Exception("myService could not return result"))
                .build();
    }
}