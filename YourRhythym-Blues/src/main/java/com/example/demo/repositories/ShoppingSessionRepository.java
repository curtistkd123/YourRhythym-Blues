package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ShoppingSession;

@Repository
public interface ShoppingSessionRepository extends CrudRepository<ShoppingSession, Long> {

}
