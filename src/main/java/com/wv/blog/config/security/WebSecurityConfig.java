package com.wv.blog.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wv.blog.domain.user.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserServiceImpl userService;
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
        	.antMatchers("/css/**")
        	.antMatchers("/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        	http
                .authorizeRequests()  
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/board/board").authenticated()
                .antMatchers("/board/form").authenticated()
                .anyRequest().permitAll()
            .and()
                .formLogin()
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/") 
                .permitAll()
            .and()
                .logout()  
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
        	.and()
        		.csrf().disable()
        		.headers().frameOptions().disable();
//                .deleteCookies("cookies") 
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}
