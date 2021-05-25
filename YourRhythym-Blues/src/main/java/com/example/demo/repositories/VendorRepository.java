package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Vendor;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {

}
