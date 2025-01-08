package com.masterPdv.MasterPdv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig extends OpenAPI {

	@Bean
	public OpenAPI customizeSwagger() {
		return new OpenAPI()
				  .components(new Components())
				;
	}
	
}
