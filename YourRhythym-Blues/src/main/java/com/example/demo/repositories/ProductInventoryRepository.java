package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ProductInventory;

@Repository
public interface ProductInventoryRepository extends CrudRepository<ProductInventory, Long> {

}
