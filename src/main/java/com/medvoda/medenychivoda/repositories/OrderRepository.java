package com.medvoda.medenychivoda.repositories;

import com.medvoda.medenychivoda.Entity.OrderEntity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    void save(Package order);


}
