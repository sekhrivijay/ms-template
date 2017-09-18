package com.services.micro.template.demo.api.response;

import java.io.Serializable;

public class ServiceResponse implements Serializable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
