package com.jacksonzhou.spring.serviceconsumer1.web;

import com.jacksonzhou.spring.serviceconsumer1.util.CommonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/userConsumerApi")
public class UserConsumerWithFeignController {

    @Autowired
    CommonInterface commonInterface;

    @RequestMapping(value = "/getUser2", method = RequestMethod.GET)
    public String getUser() {
        ResponseEntity<Map> responseEntity = commonInterface.getUserInfor();
        System.out.println("responseEntity" + responseEntity.toString());
        return "hello,I am consumer,nice to meet you!";
    }

}
