package com.medvoda.medenychivoda.services;

import com.medvoda.medenychivoda.Entity.OrderEntity.Order;
import com.medvoda.medenychivoda.repositories.OrderRepository;
import com.medvoda.medenychivoda.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService( OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }
}
