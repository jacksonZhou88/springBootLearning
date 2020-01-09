package com.jacksonzhou.spring.serviceconsumer1.web;

import com.jacksonzhou.spring.serviceconsumer1.service.UserConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class UserConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    UserConsumerService userConsumerService;

    @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "helloKey")
    @RequestMapping("/getUser")
    public String getUser() {
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity("http://service-provide/getUserInfor", Map.class);
        Map<String, Object> resultMap = responseEntity.getBody();
        return "hello,I am consumer,nice to meet you! I'm instance " + resultMap.get("instanceId");
    }


    @RequestMapping("/helloFallback")
    public String helloFallback() {
        return "连接超时！";
    }

    /**
     * <p>功能描述：getUser2 断路器功能</p>
     * <ul>
     * <li>@param []</li>
     * <li>@return java.lang.String</li>
     * <li>@throws </li>
     * <li>@author My</li>
     * <li>@date 2020/1/4 19:07</li>
     * </ul>
     */
    @RequestMapping("/getUserApi")
    public String getUserApi() {
        Map<String, Object> userMap = userConsumerService.getUser2();
        return "hello,I am consumer,nice to meet you! I'm instance " + userMap.get("instanceId");
    }

}
