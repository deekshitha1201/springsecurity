package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.User;
import com.example.Repository.UserRepository;
@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	@Override
	public User adduser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
