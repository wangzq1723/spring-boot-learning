package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

/**
 * @author wzq
 * @date 2021/01/04/15:52
 */
public class BaseControllerTest {

    private MockMvc mvc;

    @Autowired
    protected WebApplicationContext wac;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    protected void sendHttpGetRequest(String url, Map<String, String> requestParams) {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(url);
        for (String key : requestParams.keySet()) {
            builder.param(key, requestParams.get(key));
        }

        try {
            MvcResult mvcResult = mvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
            String result = mvcResult.getResponse().getContentAsString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendHttpPostRequest(String url, Map<String, Object> requestParams) {
        RequestBuilder request = MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(requestParams));
        try {
            String result = mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
