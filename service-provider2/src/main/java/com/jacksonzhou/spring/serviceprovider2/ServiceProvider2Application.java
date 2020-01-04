package com.jacksonzhou.spring.serviceprovider1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider2Application.class, args);
    }

}
