package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Entity.User;
import com.example.Repository.UserRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SecuritydatabaseApplication {
	@Autowired
	private UserRepository userrpo;
	@PostConstruct
	public void initUsers()
	{
		List<User> users = Stream.of(
				new User(101,"deekshitha","password","deekshu@gmail.com"),
				new User(102,"user1","pwd1","user1@gmail.com"),
				new User(103,"user2","pwd2","user2@gmail.com"),
				new User(104,"user3","pwd3","user3@gmail.com")		
				).collect(Collectors.toList());
		        userrpo.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SecuritydatabaseApplication.class, args);
	}

}
