package com.wv.blog.domain.user;

import java.util.Collection;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Data;

@Data
public class UserDto implements UserDetails{

	private Long id;
	@NotNull
	@Email(message = "이메일 양식이 맞지 않습니다.")
	private String email;
	private String password;
	
	private Role auth;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public UserDto() {}
	
	public UserDto(User user) {
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.auth = user.getRole();
	}
	
	public User toEntity() {
		return new User().builder()
				.id(this.id)
				.email(this.email)
				.password(this.password)
				.role(this.auth)
				.build();
	}

}
