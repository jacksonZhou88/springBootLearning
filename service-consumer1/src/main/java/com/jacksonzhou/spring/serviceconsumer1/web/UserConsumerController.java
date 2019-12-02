package com.jacksonzhou.spring.serviceconsumer1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class UserConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    private final String providerUrl = "http://service-provide1/getUserInfor";

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/getUser")
    public String getUser(){
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity("http://service-provide1/getUserInfor", Map.class);
        System.out.println("responseEntity" + responseEntity.toString());
        return "hello,I am consumer,nice to meet you!";
    }

}
