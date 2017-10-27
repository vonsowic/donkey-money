package com.iobestgroup.donkeymoney.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author miwas
 * @version 1.0
 * @since 21.10.17
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    /*
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/signin")
                .permitAll()
                .and()
                .logout()
                */
                .authorizeRequests()
                .antMatchers("/**").permitAll();    // na razie nie ma autoryzcji, więc każdy url jest dozwolony

        http.csrf().disable();
    }
}
