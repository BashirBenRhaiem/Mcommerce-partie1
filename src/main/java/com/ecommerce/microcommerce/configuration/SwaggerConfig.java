package com.ecommerce.microcommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        //Docket est l'objet de swagger qui contient toute les configurations, on l'utilise pour filtrer ce qu'on souhaite afficher
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ecommerce.microcommerce.web"))
                .paths(PathSelectors.regex("/Produits.*"))
                .build()
                .apiInfo(apiEndPointsInfo())
                .tags(new Tag("Gestion de produit", "une module de gestion de produit"));
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Gestion de produit API's")
                .description("Gestion de produit API's")
                .version("1.0").build();
    }
}