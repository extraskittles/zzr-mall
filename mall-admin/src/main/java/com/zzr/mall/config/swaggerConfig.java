package com.zzr.mall.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.zzr.skittles.controller"})
public class swaggerConfig {
    @Value("${zzr.hostname}")
    public String hostname;
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(hostname)
                .apiInfo(apiinfo());
    }

    private ApiInfo apiinfo() {
        Contact contact = new Contact("skittles", "www.test.com", "583846780@qq.com");
        return new ApiInfoBuilder()
                .title("skittles项目API接口")
                .description("包括用户、商家、购物车、订单的接口")
                .contact(contact)
                .version("1.1.0")
                .build();
    }
}
