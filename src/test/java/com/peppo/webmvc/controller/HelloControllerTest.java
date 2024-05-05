package com.peppo.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloGuest() throws Exception {
        mockMvc.perform(
                get("/hello")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Guest"))
        );
    }

    @Test
    void helloName() throws Exception {
        mockMvc.perform(
                get("/hello").queryParam("name", "haris")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello haris"))
        );
    }

    @Test
    void helloPost() throws Exception {
        mockMvc.perform(
                post("/hello").queryParam("name", "haris")
        ).andExpectAll(
                status().isMethodNotAllowed()
        );
    }

    @Test
    void testHelloView() throws Exception {
        mockMvc.perform(
                get("/web/hello")
                        .queryParam("name", "haris")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("belajar view")),
                content().string(Matchers.containsString("Hello haris"))
        );
    }

    @Test
    void testHelloViewRedirect() throws Exception {
        mockMvc.perform(
                get("/web/hello")
        ).andExpectAll(
                status().is3xxRedirection()
        );
    }
}