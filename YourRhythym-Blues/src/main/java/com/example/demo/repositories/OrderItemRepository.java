package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
	
}
