package com.platzi.market.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.platzi.market.web.controller"))
                .build().apiInfo(apiEndpointsInfo());
    }

    private ApiInfo apiEndpointsInfo(){
        return new ApiInfoBuilder().title("Documentacion de Platzi Market")
                .description("Endpoints para el funcionamiento de un mercado virtual")
                .license("Apache 2.0")
                .version("0.0.8")
                .build();
    }
}
