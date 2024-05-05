package com.peppo.webmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CodeController {

    @DeleteMapping("/delete/{productId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(Integer id) {
        // delete to database
    }
}
