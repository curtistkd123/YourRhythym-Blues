package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserPayment;

@Repository
public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

}
