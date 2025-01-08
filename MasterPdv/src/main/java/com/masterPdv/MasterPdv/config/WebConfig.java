package com.masterPdv.MasterPdv.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class WebConfig extends WebMvcConfigurationSupport {

	@Value("${cors.originPatterns}")
	private List<String> corsMap = new ArrayList<>();

	@Override
	protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true);
		configurer.favorParameter(true);
		configurer.mediaType("pdf", MediaType.APPLICATION_PDF);
		configurer.defaultContentType(MediaType.APPLICATION_JSON); // Resposta padrão em JSON
		configurer.mediaType("xml", MediaType.APPLICATION_XML);
		super.configureContentNegotiation(configurer);
	}

	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("corsMap").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS",
				"PATCH");
		super.addCorsMappings(registry);
	}

}
