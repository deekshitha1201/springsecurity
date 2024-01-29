package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Configure.UserAuthenticationProvider;
import com.example.Entity.User;
import com.example.Service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserAuthenticationProvider userAuthenticationProvider;
	@PostMapping("/adduser")
	public ResponseEntity<User> adduser(@RequestBody User user)
	{
		User user1=userService.adduser(user);
		user1.setToken(userAuthenticationProvider.createToken(user1.getEmail()));
		System.out.println(" jwt token whlie register "+user1.getToken());
		return new ResponseEntity<User>(user1,HttpStatus.CREATED);
	}
	@GetMapping("/findall")
	public ResponseEntity<List<User>>retrive(){
		List<User> e=userService.getAll();
		return new ResponseEntity<>(e,HttpStatus.OK) ;
		
	}
	


}
