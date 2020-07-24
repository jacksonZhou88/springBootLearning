package com.jacksonzhou.spring.serviceconsumer1.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value = "service-provide1")
public interface CommonInterface {

    @RequestMapping(value = "/getUserInfor")
    ResponseEntity<Map> getUserInfor();
}
