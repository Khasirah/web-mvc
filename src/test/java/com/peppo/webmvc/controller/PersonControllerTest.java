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
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreatePerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "haris")
                        .param("email", "haris@haris.com")
                        .param("phone", "123456789")
                        .param("address.street", "jalan kembang")
                        .param("address.city", "jakarta")
                        .param("address.country", "indonesia")
                        .param("address.postalCode", "12345")
                        .param("hobbies[0]", "read")
                        .param("hobbies[1]", "coding")
                        .param("hobbies[2]", "sleeping")
                        .param("socialMedias[0].name", "facebook")
                        .param("socialMedias[0].location", "facebook.com/haris")
                        .param("socialMedias[1].name", "instagram")
                        .param("socialMedias[1].location", "instagram.com/haris")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("success create person haris email: haris@haris.com" +
                        " phone: 123456789 street: jalan kembang city: jakarta country: indonesia postal code: 12345"))
        );
    }

    @Test
    void testCreatePersonValidationError() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "haris@haris.com")
                        .param("phone", "123456789")
                        .param("address.street", "jalan kembang")
                        .param("address.city", "jakarta")
                        .param("address.country", "indonesia")
                        .param("address.postalCode", "12345")
                        .param("hobbies[0]", "read")
                        .param("hobbies[1]", "coding")
                        .param("hobbies[2]", "sleeping")
                        .param("socialMedias[0].name", "facebook")
                        .param("socialMedias[0].location", "facebook.com/haris")
                        .param("socialMedias[1].name", "instagram")
                        .param("socialMedias[1].location", "instagram.com/haris")
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("you send invalid data"))
//                content().string(Matchers.containsString("Validation Error: "))
        );
    }
}