package com.example.demo.restservice;

import org.springframework.stereotype.Service;

/**
 * @author wzq
 * @date 2021/01/08/11:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void print() {
        System.out.println("degradation");
    }
}
