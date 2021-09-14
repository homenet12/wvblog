package com.wv.blog.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/dummy")
	public void makeDummy() {
		
		User user = new User().builder()
				.email("chd@naver.com")
				.password(encoder.encode("1234"))
				.role(Role.ADMIN)
				.build();
		
		repository.save(user);
	}
}
