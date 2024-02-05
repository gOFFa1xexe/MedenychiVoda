package com.medvoda.medenychivoda.controllers;

import com.medvoda.medenychivoda.Entity.OrderEntity.Order;
import com.medvoda.medenychivoda.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public String showOrder(){
        return "orders";
    }
    @PostMapping("/create-order")
    public String createOrder(@ModelAttribute Order order) {

        orderService.saveOrder(order);

        return "orders";
    }

}
