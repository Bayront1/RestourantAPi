package com.example.restaurantapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Autowired
    @Lazy
    private RestTemplate restTemplate;
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder(8);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(getPasswordEncoder())
                .usersByUsernameQuery("select username, password, active from model_user where username =?")
                .authoritiesByUsernameQuery("select u.username, u.role from model_user u where u.username=?");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable();

        http.authorizeRequests()
                .antMatchers("/api/public/**").permitAll()
                .antMatchers("/api/private/**").authenticated()
                .anyRequest().authenticated();

        http.formLogin().disable();
        http.logout().disable();
    }
}