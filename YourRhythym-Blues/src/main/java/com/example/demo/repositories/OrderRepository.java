package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
