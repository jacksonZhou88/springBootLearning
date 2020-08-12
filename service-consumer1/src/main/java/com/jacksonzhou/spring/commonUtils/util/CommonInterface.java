package com.jacksonzhou.spring.commonUtils.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value = "service-provide")
public interface CommonInterface {

    @RequestMapping(value = "/getUserInfor")
    ResponseEntity<Map> getUserInfor();
}
