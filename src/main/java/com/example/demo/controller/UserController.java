package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    public String HomePage() {
        return "user/home"; // По шаблону home вызываем другой шаблон
    }

    @GetMapping("/telephone")
    public String TelephonePage() {
        return "user/telephone";
    }

    @GetMapping("/order")
    public String OrderPage() {
        return "user/order";
    }
}
