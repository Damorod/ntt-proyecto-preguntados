package config;

import org.springframework.context.annotation.Configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api-preguntados").apiInfo(apiInfo())
				.select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.regex("/nttpreguntados.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Preguntados")
				.description("API  preguntados.")
				.termsOfServiceUrl("http://en.wikipedia.org/wiki/Terms_of_service")
				.license("Apache License Version 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("2.0").build();
	}
}