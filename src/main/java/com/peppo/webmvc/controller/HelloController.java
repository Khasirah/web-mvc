package com.peppo.webmvc.controller;

import com.peppo.webmvc.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

//    @RequestMapping(path = "/hello", method = RequestMethod.GET)
//    @GetMapping("/hello") // annotation mapping method pake ini aja lebih cepet
//    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String name = request.getParameter("name");
//        String responBody = helloService.hello(name);
////        if (Objects.isNull(name)) {
////            name = "Guest";
////        }
//        response.getWriter().println(responBody);
//    }

    @GetMapping("/hello") // annotation mapping method pake ini aja lebih cepet
    public void helloWorld(@RequestParam(name = "name", required = false) String name,
                           HttpServletResponse response) throws IOException {
        String responBody = helloService.hello(name);
//        if (Objects.isNull(name)) {
//            name = "Guest";
//        }
        response.getWriter().println(responBody);
    }

    @GetMapping("/web/hello")
    public ModelAndView hello(@RequestParam(name = "name", required = false) String name) {
        if (Objects.isNull(name)) {
            return new ModelAndView("redirect:/web/hello?name=Guest");
        }
        return new ModelAndView("hello", Map.of(
                "title", "belajar view",
                "name", name
        ));
    }
}
