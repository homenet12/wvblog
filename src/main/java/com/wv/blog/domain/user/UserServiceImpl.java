package com.wv.blog.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author homen
 *
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
		UserDto userDto = new UserDto(user);
		log.info("___________________");
		log.info(user.getPassword());
		log.info(userDto.getEmail());
		log.info(userDto.getPassword());
		log.info("___________________");
		return userDto;
	}

	@Override
	public void signIn(UserDto userDto) {
		User user = userDto.toEntity();
		boolean alreadySign = repository.existsByEmail(user.getEmail());
		if(!alreadySign) throw new IllegalArgumentException("이미 아이디가 존재합니다.");
		repository.save(user);
	}
	
	

}
