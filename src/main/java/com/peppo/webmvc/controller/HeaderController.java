package com.peppo.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @GetMapping(path = "/header/token")
    @ResponseBody
    public String header(@RequestHeader(name = "X-TOKEN") String token) { // @RequestHeader untuk mengirim data dalam bentuk request header
        if ("xxx".equals(token)) {
            return "mantap";
        } else {
            return "token tidak sesuai";
        }
    }
}
