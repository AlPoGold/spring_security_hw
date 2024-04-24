package com.example.spring_security_hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @GetMapping("/public-data")
    public String publicData(){
        return "public-data";
    }

    @GetMapping("/private-data")
    public String privateData(){
        return "private-data";
    }

    @GetMapping("/login")
    public String loginRequest(){
        return "login";
    }

}
