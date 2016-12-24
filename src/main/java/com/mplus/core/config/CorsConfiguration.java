package com.mplus.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfiguration {

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//			.allowedOrigins("*")
//			.allowedMethods(
//					HttpMethod.GET.name(),
//					HttpMethod.HEAD.name(), 
//					HttpMethod.POST.name(), 
//					HttpMethod.PUT.name(),
//					HttpMethod.PATCH.name(),
//					HttpMethod.DELETE.name(),
//					HttpMethod.OPTIONS.name(),
//					HttpMethod.TRACE.name());
//	}
	
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
//				super.addCorsMappings(registry);
				registry.addMapping("/api/**");
			}
		};
	}
}
