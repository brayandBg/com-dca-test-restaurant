package com.dca.test.restaurant.documentacion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class DocumentacionApi {

    @Bean
    public Docket api() {
        final Docket build = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(queryApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dca.test.restaurant"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag("API TEST RESTAURANT", "Esta API es una prueba dentro del entrenamiento DCA que implicará un restaurante")
                );
        return build;
    }

    public ApiInfo queryApiInfo() {
        return new ApiInfoBuilder()
                .title("TEST RESTAURANT")
                .description("API de test restaurant")
                .version("1.0.0")
                .license("Test Restaurant License Version 1.0")
                .licenseUrl("http://www.dcatech.com")
                .contact(new Contact("DCA Technology", "http://www.dcatech.com", "info@dcatech.com"))
                .build();
    }

}
