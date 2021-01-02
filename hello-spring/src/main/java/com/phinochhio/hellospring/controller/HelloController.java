package com.phinochhio.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") //html에서 hello주소로 가면 이쪽으로 넘어옴
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";
    }
}
