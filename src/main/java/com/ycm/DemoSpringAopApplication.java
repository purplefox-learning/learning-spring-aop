package com.ycm;

import com.ycm.service.DemoService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringAopApplication implements CommandLineRunner {

    private final DemoService1 demoService1;

    @Autowired
    public DemoSpringAopApplication(DemoService1 demoService1) {
        this.demoService1 = demoService1;
    }

    public static void main(String[] args) {
        //continue running
        //SpringApplication.run(DemoSpringAopApplication.class, args);

        //or stop immediately after running
        SpringApplication.run(DemoSpringAopApplication.class, args).close();
    }

    @Override
    public void run(String... args) throws Exception {
        demoService1.getMessage();
        demoService1.add(5,5);
    }
}
