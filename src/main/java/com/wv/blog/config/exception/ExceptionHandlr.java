package com.wv.blog.config.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionHandlr {

	@ExceptionHandler(value = IllegalArgumentException.class)
	public String exceptionHandler(IllegalArgumentException ex) {
		return ex.getMessage();
	}
}
