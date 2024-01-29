package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Entity.User;
@Service
public interface UserService {
	public User adduser(User user);
	
	public List<User> getAll();
	
	

}
