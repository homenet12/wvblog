package com.wv.blog.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
    // 암호화
        return new BCryptPasswordEncoder();
    }

    // 정적 자원에 대해서는 Security 설정을 적용하지 않음.
    // WebSecurity는 FilterChainProxy 생성 필터입니다.
    @Override
    public void configure(WebSecurity web) {
        // 해당 경로의 파일들은 spring security가 무시하도록합니다.
        web.ignoring()
        	.antMatchers("/css/**")
        	.antMatchers("/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        	http
                .authorizeRequests() // HttpServletRequest에 따라접근을 제한
                .antMatchers("/h2-console/**").permitAll() // url에 따른 모두 허용
                .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/login") // 지정하고 싶은 로그인 페이지 url 
                .usernameParameter("email") // 지정하고 싶은 username name 명칭이며, 기본은 username
                .passwordParameter("password") // 지정하고 싶은 password name 명칭이며, 기본은 password
                .defaultSuccessUrl("/") // 로그인 성공 시 이동페이지
                .permitAll() // 모두 접근 허용
            .and()
                .logout() // 로그아웃 
                .logoutUrl("/logout") // 지정하고 싶은 로그아웃 url
                .logoutSuccessUrl("/") // 성공 시 이동 페이지
                .invalidateHttpSession(true)// 세션 초기화
        	.and()
        		.csrf().disable()
        		.headers().frameOptions().disable();
//                .deleteCookies("cookies") // 특정 쿠키를 제거
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // 비밀번호 암호화
        //auth.userDetailsService(securityMemverService).passwordEncoder(bCryptPasswordEncoder());
    }
}
