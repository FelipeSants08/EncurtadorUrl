package com.santana.encurtador.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Encurtador de URL")
                        .description("Serviço de redução da URL, para facilitar pesquisas")
                        .contact(new Contact().email("santanadevfe@gmail.com").name("Felipe Santana"))
                        .version("1.0")
                );
    }

}
