package com.ycm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService1 {

    private final DemoService2 service2;

    @Autowired
    public DemoService1(DemoService2 s2) {
        this.service2 = s2;
    }

    public String getMessage() {
        return "Hello, DemoService1 is alive";
    }

    public int add(int a,int b) {
        return service2.add(a,b);
    }
}