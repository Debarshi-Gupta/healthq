package com.healthq.Members;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer
{
	
	 @Bean
	 public Docket docket() 
	 { 
	     return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                                            
	          .build();                                           
	 }
	    
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) 
	 {
		 registry.addResourceHandler("swagger-ui.html")
	            .addResourceLocations("classpath:/META-INF/resources/");
	     registry.addResourceHandler("/webjars/**")
	            .addResourceLocations("classpath:/META-INF/resources/webjars/");
	 }
	 

}

