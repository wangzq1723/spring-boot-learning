package com.example.demo.controller;

import com.example.demo.BaseControllerTest;
import com.example.demo.DemoApplication;
import com.example.demo.restservice.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wzq
 * @date 2021/01/04/16:51
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
//@WebAppConfiguration
public class GreetingControllerTest extends BaseControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGreeting() {
        String url = "/greeting";
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("name", "Daniel");
        sendHttpGetRequest(url, requestParams);
    }

    @Test
    public void testAddGreeting() {
        String url = "/greeting";
        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put("name", "Daniel");
        sendHttpPostRequest(url, requestParams);
    }

    @Test
    public void test1() {
        userService.print();
    }
}
