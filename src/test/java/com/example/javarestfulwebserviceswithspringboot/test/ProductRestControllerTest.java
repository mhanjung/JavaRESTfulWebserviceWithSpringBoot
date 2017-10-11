package com.example.javarestfulwebserviceswithspringboot.test;

import com.example.javarestfulwebserviceswithspringboot.JavarestfulwebserviceswithspringbootApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductRestControllerTest extends JavarestfulwebserviceswithspringbootApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void productFindTest() throws Exception {
        mockMvc.perform(get("/api/product/find"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").value("p01"))
                .andExpect(jsonPath("$.name").value("name1"));
    }

    @Test
    public void productFindAllTest() throws Exception {
        mockMvc.perform(get("/api/product/findall"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.[0].id").value("p01"))
                .andExpect(jsonPath("$.[0].name").value("name1"))
                .andExpect(jsonPath("$.[1].id").value("p02"))
                .andExpect(jsonPath("$.[1].name").value("name2"))
                .andExpect(jsonPath("$.[2].id").value("p03"))
                .andExpect(jsonPath("$.[2].name").value("name3"));
    }

    @Test
    public void demo0Test() throws Exception {
        mockMvc.perform(get("/api/demo/demo0"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("Hi there!"));
    }

    @Test
    public void demo1Test() throws Exception {
        mockMvc.perform(get("/api/demo/demo1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("Demo 1"));
    }

    @Test
    public void demo2Test() throws Exception {
        mockMvc.perform(get("/api/demo/demo2"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("<b>Demo 2</b>"));
    }

    @Test
    public void demo3Test() throws Exception {
        mockMvc.perform(get("/api/demo/demo3/John"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("Hi John"));
    }
}
