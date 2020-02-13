package com.jacksonzhou.spring.serviceprovider1.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserProvider {

    private static final Logger log = LoggerFactory.getLogger(UserProvider.class);

    @GetMapping("/getUserInfor")
    @ResponseBody
    public Map<String, Object> getUserInfor() {
        System.out.println("=====serviceInstance1=====");
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "jackson");
        userMap.put("mobile", "13588294068");
        userMap.put("address", "浙江省杭州市西湖区");
        userMap.put("instanceId", "instance1");
//        int sleepTime = new Random().nextInt(5000);
//        try {
//            Thread.sleep(sleepTime);
//            log.info("sleepTime: " + sleepTime);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            return null;
//        }

        return userMap;
    }
}
