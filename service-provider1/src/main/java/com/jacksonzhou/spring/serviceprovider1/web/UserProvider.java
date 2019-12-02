package com.jacksonzhou.spring.serviceprovider1.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserProvider {

    @GetMapping("/getUserInfor")
    @ResponseBody
    public Map<String, Object> getUserInfor(){
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "jackson");
        userMap.put("mobile", "13588294068");
        userMap.put("address", "浙江省杭州市西湖区");
        return userMap;
    }
}
