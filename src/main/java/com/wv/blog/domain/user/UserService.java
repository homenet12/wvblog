package com.wv.blog.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("������ �������� �ʽ��ϴ�."));
		UserDto userDto = new UserDto(user);
		return userDto;
	}

}
