package com.jacksonzhou.spring.serviceconsumer1.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "service-provide1")
public interface CommonInterface {

    @RequestMapping(method = RequestMethod.GET, value = "/getUserInfor")
    ResponseEntity<Map> getUserInfor();
}
