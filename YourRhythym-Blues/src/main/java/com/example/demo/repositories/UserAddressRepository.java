package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserAddress;

@Repository
public interface UserAddressRepository extends CrudRepository<UserAddress, Long> {

}
