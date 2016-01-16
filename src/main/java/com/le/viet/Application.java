package com.le.viet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	System.out.println("test jenkins");
        SpringApplication.run(Application.class, args);
    }
}