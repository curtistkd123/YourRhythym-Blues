package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
