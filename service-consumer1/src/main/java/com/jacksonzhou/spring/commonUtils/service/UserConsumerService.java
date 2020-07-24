package com.jacksonzhou.spring.commonUtils.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class UserConsumerService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * <p>功能描述：getUser2 消费者消费</p>
     * <ul>
     * <li>@param []</li>
     * <li>@return java.lang.String</li>
     * <li>@throws </li>
     * <li>@author My</li>
     * <li>@date 2020/1/4 19:10</li>
     * </ul>
     */
    public Map<String, Object> getUser2() {
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity("http://service-provide/getUserInfor", Map.class);
        Map<String, Object> resultMap = responseEntity.getBody();
        return resultMap;
    }

}
