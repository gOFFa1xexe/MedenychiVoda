package com.medvoda.medenychivoda.Entity.OrderEntity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order {
    @Column(name = "order_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_time")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "customer_number")
    private String customerNumber;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(this);
            this.orderItems.add(orderItem);
        }

    }
}