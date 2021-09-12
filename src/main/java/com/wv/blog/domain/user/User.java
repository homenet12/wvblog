package com.wv.blog.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.wv.blog.config.entity.BaseEntity;

import lombok.Getter;

@Entity
@Getter
public class User extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "auth")
	private Role auth;
}
