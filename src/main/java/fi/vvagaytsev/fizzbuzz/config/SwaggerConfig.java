package fi.vvagaytsev.fizzbuzz.config;

import io.swagger.annotations.Api;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Set;

import static java.util.Collections.singleton;

/**
 * @author Vladimir Vagaytsev
 * Date: 09/08/2018
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = singleton("application/json");
    private static final Set<String> DEFAULT_PROTOCOLS = singleton("http");

    @Bean
    public Docket api(ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .forCodeGeneration(true)
                .groupName("fizz-buzz")
                .protocols(DEFAULT_PROTOCOLS)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo(BuildProperties buildProperties) {
        return new ApiInfoBuilder()
                .title("FizzBuzz REST API")
                .description("FizzBuzz REST API reference for developers")
                .version(buildProperties.getVersion())
                .build();
    }
}