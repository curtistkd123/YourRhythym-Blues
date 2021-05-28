package com.example.demo.repositories;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;
import com.example.demo.models.Vendor;

@Repository
public interface VendorRepository extends CrudRepository<Vendor,Long> {

	@Valid Vendor findByEmail(String email);

}
