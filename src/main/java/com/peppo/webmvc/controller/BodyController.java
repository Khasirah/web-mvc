package com.peppo.webmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peppo.webmvc.model.HelloRequest;
import com.peppo.webmvc.model.HelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BodyController {

    @Autowired
    private ObjectMapper objectMapper;
    // urusan dengan json

    @PostMapping(
            path = "/body/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public String body(@RequestBody String requestBody) throws JsonProcessingException {
        HelloRequest request = objectMapper.readValue(requestBody, HelloRequest.class);

        HelloResponse response = new HelloResponse();
        response.setHello("Hello "+request.getName());

        return objectMapper.writeValueAsString(response);
    }
}
