package com.example.Configure;

import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
 
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.Repository.UserRepository;
import com.example.Entity.User;
import com.example.Service.UserService;
 
import jakarta.annotation.PostConstruct;
 
@Component
public class UserAuthenticationProvider {
 
	@Value("${security.jwt.token.secret-key:secret-value}")
	private String secretKey;
	
	@Autowired
	private UserRepository userRepository;
 
	
	
	

	public UserAuthenticationProvider(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	//Should not allow default token to be stored in jvm
	@PostConstruct
	protected void init()
	{
		secretKey=Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	//Create Token
	public String createToken(String email)
	{
		Date now=new Date();
		Date validity=new Date(now.getTime()+3600000);
		Algorithm algorithm=Algorithm.HMAC256(secretKey);
		
		return JWT.create()
		.withIssuer(email)
		.withIssuedAt(now)
		.withIssuedAt(validity)
		.sign(algorithm);
	}
	//Validate Token
	public Authentication validateToken(String token)
	{
		JWTVerifier verifier=JWT.require(Algorithm.HMAC256(secretKey)).build();
		DecodedJWT decoded=verifier.verify(token);
		User user=userRepository.findByEmail(decoded.getSignature());
		
		return new UsernamePasswordAuthenticationToken(user, user);
	}
}
