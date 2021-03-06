package com.niit.foodshope.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration

@EnableWebMvc

@ComponentScan(basePackages="com.niit")
public class ViewResolverConfiguration {
	@Bean(name="dataSource")

	public DataSource getDataSource()

	{

		System.out.println("get Datasourcemethod called");

		DriverManagerDataSource  dataSource=new DriverManagerDataSource();

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("fa");

		dataSource.setPassword("");

		dataSource.setUrl("jdbc:h2:tcp://localhost/~/fs");

		return dataSource;

	}


	 @Bean

	    public ViewResolver viewResolver() {

	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

	        viewResolver.setViewClass(JstlView.class);

	        viewResolver.setPrefix("/WEB-INF/view/");

	        viewResolver.setSuffix(".jsp");

	        return viewResolver;

	    }


	 @Bean(name="multipartResolver") 

	 public MultipartResolver getMultiResolver(){

		 CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();

		 return multipartResolver;

	 }

}
