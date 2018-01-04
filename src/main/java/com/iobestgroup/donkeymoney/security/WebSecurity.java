package com.iobestgroup.donkeymoney.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().ena();
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/**", "/*").permitAll();
    }
}