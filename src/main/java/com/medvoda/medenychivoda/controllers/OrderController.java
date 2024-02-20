package com.medvoda.medenychivoda.controllers;

import com.medvoda.medenychivoda.Entity.OrderEntity.Order;
import com.medvoda.medenychivoda.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value = "/create-order",consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<String> createOrder(@Valid@RequestBody Order order) {
        try {
            orderService.saveOrder(order);
            return new ResponseEntity<>("Order created successfully with id "+ order.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create order: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
