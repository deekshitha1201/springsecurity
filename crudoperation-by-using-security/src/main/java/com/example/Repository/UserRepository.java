package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	//public User findByEmail(String email);

	public User findByEmail(String signature);

}
