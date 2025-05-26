package com.nt.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repo.UserRepository;
@Service
public class UserService {

	private final UserRepository UserRepo;
	private final PasswordEncoder PasswordEncoder;
	
	
	public UserService(UserRepository UserRepo, PasswordEncoder PasswordEncoder)
	{
		this.PasswordEncoder=PasswordEncoder;
		this.UserRepo=UserRepo;	
	}
	public User registerUser(User user)
	{
		user.setPassword(PasswordEncoder.encode(user.getPassword()));
	    user.setRole("USER");
	    return UserRepo.save(user);
		
	}
	
	public Optional<User> findByUsername(String username)
	{
		return UserRepo.findByUsername(username);
	}
}
