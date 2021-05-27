package com.example.demo.services;

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
	
	public boolean authenticateUser(String email, String password) {
		User user = uRepo.findByEmail(email);
			if(user == null) {
				return false;
			}else {
				if(BCrypt.checkpw(password, user.getPassword())) {
					return true;
				}else {
					return false;
				}
			}
		}

	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		return uRepo.findById(id).orElse(null);
	}

	public @Valid User findByEmail(String email) {
		// TODO Auto-generated method stub
		return uRepo.findByEmail(email);
	}
	
	
}
