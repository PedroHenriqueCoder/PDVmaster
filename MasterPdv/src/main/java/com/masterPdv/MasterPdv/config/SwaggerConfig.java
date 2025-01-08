package com.masterPdv.MasterPdv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig extends OpenAPI {

	@Bean
	public OpenAPI customizeSwagger() {
		return new OpenAPI()
				  .components(new Components())
				  .info(new Info()
						  .title("MasterPDV - Ponto de Vendas Ultra Dinâmico V0.1")
						  .description("Documentação da API para o sistema Master PDV")
	                      .version("1.0.0")
	                      .license(new License()
	                                .name("Apache 2.0")
	                                .url("http://springdoc.org")));

						  

	}
	
}
