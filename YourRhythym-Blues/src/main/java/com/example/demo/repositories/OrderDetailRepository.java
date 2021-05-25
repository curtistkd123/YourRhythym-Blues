package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.OrderDetail;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {

}
