package config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import postgresql.Application;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = { Application.class })
public class SwaggerConfig {
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api-preguntados").apiInfo(getApiInfo())
				.select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.regex("/preguntados.*")).build();
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("Order Service API", "Order Service API Description", "1.0", "http://codmind.com/terms",
				new Contact("Codmind", "https://codmind.com", "apis@codmind.com"), "LICENSE", "LICENSE URL",
				Collections.emptyList()

		);
	}
	
	
}
