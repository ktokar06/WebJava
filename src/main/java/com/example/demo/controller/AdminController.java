package com.example.demo.controller;

import com.example.demo.services.AdminService;
import com.example.demo.services.OrderService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    public AdminController() {}

    @GetMapping("/")
    public String adminPage() {
        return "admin/index";
    }
}
