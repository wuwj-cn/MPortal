package com.mplus.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class CorsConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods(
					HttpMethod.GET.name(),
					HttpMethod.HEAD.name(), 
					HttpMethod.POST.name(), 
					HttpMethod.PUT.name(),
					HttpMethod.PATCH.name(),
					HttpMethod.DELETE.name(),
					HttpMethod.OPTIONS.name(),
					HttpMethod.TRACE.name());
	}
}
