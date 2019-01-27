package com.ycm.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService2 {

    public String getMessage() {
        return "Hello, DemoService2 is alive";
    }

    public int add(int a,int b) {
        return a+b;
    }
}
