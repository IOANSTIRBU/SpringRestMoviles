package com.ejercicios.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * 
 * @author Ioan Stirbu
 *
 */


@Configuration
public class OpenApiConfiguration {
	
	/**
	 * 
	 * @return Se encarga de poner la información especifica de la API
	 * 
	 */

	@Bean
	public OpenAPI MobileOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Mobile API")
				.description("Documentacion de Movil API")		
				.version("v1.0")
				.contact(new Contact().name("Ioan Stirbu").
						url("https://ioanstirbu.es").email("ioan@stirbu.es"))
				.license(new License().name("Licencia de Pago").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation()
				.description("Descripcion del proyecto Movil")
				.url("https://miproyecto.es"));
						
	}
	
}
