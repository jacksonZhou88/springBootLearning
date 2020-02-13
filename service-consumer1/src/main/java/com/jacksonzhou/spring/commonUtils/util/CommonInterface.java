package com.jacksonzhou.spring.commonUtils.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "service-provide")
public interface CommonInterface {

    @RequestMapping(method = RequestMethod.GET, value = "/getUserInfor")
    ResponseEntity<Map> getUserInfor();
}
