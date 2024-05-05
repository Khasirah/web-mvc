package com.peppo.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddTodo() throws Exception {
        mockMvc.perform(
                post("/todos")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("todo", "makan")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("makan"))
        );
    }

//    @Test
//    void testGetTodos() throws Exception {
//        mockMvc.perform(
//                get("/todos")
//                        .accept(MediaType.APPLICATION_JSON)
//        ).andExpectAll(
//                status().isOk(),
//                content().string(Matchers.containsString("makan"))
//        );
//    }

    // error krn get todos nya jalan duluan dari pada post nya

}