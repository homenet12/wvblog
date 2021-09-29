package com.wv.blog.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

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
	public RedirectView makeDummy() {
		
		User user = new User().builder()
				.id(1L)
				.email("chd@naver.com")
				.password(encoder.encode("1234"))
				.role(Role.ADMIN)
				.build();
		
		User user2 = new User().builder()
				.email("chd")
				.password(encoder.encode("1234"))
				.role(Role.ADMIN)
				.build();
		
		repository.save(user);
		repository.save(user2);
		
		return new RedirectView("/");
	}
}
