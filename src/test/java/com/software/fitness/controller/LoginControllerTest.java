package com.software.fitness.controller;

import com.alibaba.fastjson.JSON;
import com.software.fitness.domain.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class LoginControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
    }

    @Test
    void login() throws Exception {
        String json = "{phone_number:\"1\",password:\"1\"}";
        Staff staff = new Staff();
        staff.setPhone_number("1");
        staff.setPassword("1");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/index/Login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(MockMvcResultHandlers.print()).andReturn();
        //System.out.println(JSON.toJSONString(staff));
        System.out.println("result ==========" + mvcResult.getResponse().getContentAsString());
    }

    @Test
    void logout() {
    }

    @Test
    void loginPage() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/index"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
        System.out.println("result ==========" + mvcResult.getResponse().getContentAsString());
    }

}