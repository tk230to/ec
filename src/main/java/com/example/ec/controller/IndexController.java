package com.example.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/**/{path:[^.]*}")
    public String any() {
        return "forward:/index.html";
    }
}
