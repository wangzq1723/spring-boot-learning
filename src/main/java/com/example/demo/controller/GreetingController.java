package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.restservice.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wzq
 * @date 2020/12/19/22:41
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/greeting")
    public JSONObject add(@RequestBody Greeting greeting) {
        System.out.println(greeting);
        JSONObject ret = new JSONObject();
        ret.put("id", counter.incrementAndGet());
        return ret;
    }
}
