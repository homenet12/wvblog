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
    // ��ȣȭ
        return new BCryptPasswordEncoder();
    }

    // ���� �ڿ��� ���ؼ��� Security ������ �������� ����.
    // WebSecurity�� FilterChainProxy ���� �����Դϴ�.
    @Override
    public void configure(WebSecurity web) {
        // �ش� ����� ���ϵ��� spring security�� �����ϵ����մϴ�.
        web.ignoring()
        	.antMatchers("/css/**")
        	.antMatchers("/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        	http
                .authorizeRequests() // HttpServletRequest�� ���������� ����
                .antMatchers("/h2-console/**").permitAll() // url�� ���� ��� ���
                .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/login") // �����ϰ� ���� �α��� ������ url 
                .usernameParameter("email") // �����ϰ� ���� username name ��Ī�̸�, �⺻�� username
                .passwordParameter("password") // �����ϰ� ���� password name ��Ī�̸�, �⺻�� password
                .defaultSuccessUrl("/") // �α��� ���� �� �̵�������
                .permitAll() // ��� ���� ���
            .and()
                .logout() // �α׾ƿ� 
                .logoutUrl("/logout") // �����ϰ� ���� �α׾ƿ� url
                .logoutSuccessUrl("/") // ���� �� �̵� ������
                .invalidateHttpSession(true)// ���� �ʱ�ȭ
        	.and()
        		.csrf().disable()
        		.headers().frameOptions().disable();
//                .deleteCookies("cookies") // Ư�� ��Ű�� ����
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // ��й�ȣ ��ȣȭ
        //auth.userDetailsService(securityMemverService).passwordEncoder(bCryptPasswordEncoder());
    }
}
