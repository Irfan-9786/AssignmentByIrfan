package io.indpro.usermanagementsystem.services.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.indpro.usermanagementsystem.exceptions.ResourceNotFoundException;
import io.indpro.usermanagementsystem.entities.User;
import io.indpro.usermanagementsystem.repositories.UserRepository;
import io.indpro.usermanagementsystem.services.UserServices;
@Service
public class UserServicesImpl implements UserServices {
@Autowired
private UserRepository userRepository;
	@Override
	public User addUser(User user) {
		user.setCreated_at(new Timestamp(System.currentTimeMillis()));
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		User user2=this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		if(user.getUsername()==null&&user.getEmail()==null) {
			throw new RuntimeException("Both Username and email cannot be null");
		}
		if(user.getUsername()!=null) {
			user2.setUsername(user.getUsername());
		}
		if(user.getEmail()!=null) {
			user2.setEmail(user.getEmail());
		}
		
		return userRepository.save(user2);
		
	}

	@Override
	public User getUserById(Long id) {
		User user=this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		return user;
	}

}
