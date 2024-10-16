package ru.practice.dogouslugi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
      .info(new Info()
        .title("Dogouslugi API")
        .description("Методы работы с собачимиуслугами")
        .version("2.0")
        .contact(new Contact().name("Daria Bosykh"))
        .license(new License().name("Not licended")));
  }
}
