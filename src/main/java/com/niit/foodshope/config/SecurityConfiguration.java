package com.niit.foodshope.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  System.out.println("data source:"+dataSource);
	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select mailid,password,enabled from user where mailid=?")
		.authoritiesByUsernameQuery(
			"select u1.mailid, u2.rolename from user u1, userrole u2 where u1.id = u2.roleid_id and u1.mailid =?");
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
                // Spring Security should completely ignore URLs starting with /resources/
                .antMatchers("/User/signUp**").antMatchers("/Admin/Category").antMatchers("/Admin/Product");
    }


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/signUp*").permitAll();
		

	}
}
