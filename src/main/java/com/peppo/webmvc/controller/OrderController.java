package com.peppo.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @GetMapping("/orders/{orderId}/products/{productId}")
    @ResponseBody
    public String order(@PathVariable("orderId") String orderId,@PathVariable("productId") String productId) {
        return "orderId: "+orderId+", productId: "+productId;
    }
}
