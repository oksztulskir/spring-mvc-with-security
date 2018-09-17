package com.boot.example.springbootexample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/static/css/**").permitAll()
            .antMatchers("/users").hasAnyRole("ADMIN", "USER")
                .antMatchers("/user", "/user/**", "/deleteUser/**").hasAnyRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
//            .loginPage("/login")
            .permitAll()
            .and().logout()    //logout configuration
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login");
        http.csrf().disable();
    }

    @Autowired
    public void userDetailsService(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance()
                .withUser("admin").password("{noop}admin").roles("ADMIN")
                .and().withUser("user").password("{noop}user").roles("USER");
    }
}
