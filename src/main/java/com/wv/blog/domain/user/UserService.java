package com.wv.blog.domain.user;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

	public void signIn(UserDto user);
}
