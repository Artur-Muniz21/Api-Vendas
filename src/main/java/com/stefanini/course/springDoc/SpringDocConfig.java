package com.stefanini.course.springDoc;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SpringDocConfig {
	
	@Bean
	OpenAPI openApi() {
		return new OpenAPI()
				.info(new Info()
						.title("Api loja")
						.version("v1")
						.description("Sistema da loja"))
				.tags(
						Arrays.asList(
								new Tag().name("user"),
								new Tag().name("order"),
								new Tag().name("order-item"),
								new Tag().name("login-user"),
								new Tag().name("product"),
								new Tag().name("category")
								)
						);
	}
}
