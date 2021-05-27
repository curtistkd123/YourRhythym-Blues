package com.example.demo.services;

import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class HomeService {

	@Autowired
	private UserRepository uRepo;

	public User createUser(@Valid User user) {
		// TODO Auto-generated method stub
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return uRepo.save(user);
	}
	
	public User findUserById(Long id) {
		Optional<User> user = uRepo.findById(id);
			
		if(user.isPresent()) {
			return user.get();
		} else {
				return null;
			}
		}
	}

