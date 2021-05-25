package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PaymentDetail;

@Repository
public interface PaymentDetailRepository extends CrudRepository<PaymentDetail, Long> {

}
