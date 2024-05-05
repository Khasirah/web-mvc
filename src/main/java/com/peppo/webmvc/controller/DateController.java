package com.peppo.webmvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateController {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

//    @GetMapping(path = "/date")
//    public void getDate(@RequestParam(name = "date") Date date,
//                        HttpServletResponse response) throws IOException {
//        response.getWriter().println("Date: "+simpleDateFormat.format(date));
//    }

    @GetMapping(path = "/date")
    @ResponseBody // katanya string aja
    public String getDate(@RequestParam(name = "date") Date date) throws IOException {
        return "Date: "+simpleDateFormat.format(date);
    }
}
