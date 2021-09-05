package com.bookstore.app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors.any
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun productApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(any())
            .build()
            .apiInfo(metaData())
    }

    private fun metaData(): ApiInfo {
        return ApiInfo(
            "Spring Boot REST API",
            "Spring Boot REST API for Bookstore",
            "1.0",
            "Terms of service",
            Contact("Nensi Skenderi", "https://github.com/NensiSkenderi",
                "nensiskenderi15@gmail.com").toString(),
            "Apache License Version 2.0",
            "https://www.apache.org/licenses/LICENSE-2.0"
        )
    }
}