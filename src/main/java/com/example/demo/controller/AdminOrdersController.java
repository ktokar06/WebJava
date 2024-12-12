package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.CreateOrderDTO;
import com.example.demo.models.Order;
import com.example.demo.services.OrderService;

@Controller
@RequestMapping("/admin/orders")
public class AdminOrdersController {

    private OrderService orderService;

    public AdminOrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String adminListOrders(Model model) {
        List<Order> order = orderService.getAll();
        model.addAttribute("orders", order);
        return "admin/orders/index";
    }

    @GetMapping("/create")
    public String adminCreateOrders() {
        return "admin/orders/createOrder";
    }

    @PostMapping("/create")
    public String processOrder(CreateOrderDTO createOrderDTO) {
        orderService.save(createOrderDTO);
        return "redirect:/admin/orders/";
    }

    @GetMapping("/edit/{id}")
    public String adminEditOrders(@PathVariable int id, Model model) {
        model.addAttribute("order", orderService.getByID(id));
        return "admin/orders/editOrder";
    }

    @PostMapping("/edit/{id}")
    public String processAdminEditOrders(@PathVariable int id, CreateOrderDTO createOrderDTO) {
        orderService.edit(id, createOrderDTO);
        return "redirect:/admin/orders/";
    }

    @PostMapping("/delete/{id}")
    public String adminDeleteOrders(@PathVariable int id) {
        orderService.deleteByID(id);
        return "redirect:/admin/orders/";
    }

}
