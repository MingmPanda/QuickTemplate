package com.mingm.quicktemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: panmm
 * @date: 2020/6/29 03:20
 * @description: Swagger2配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * Swagger2信息
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // API 基本信息
                .apiInfo(apiInfo())

                // 设置允许暴露的接口
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.mingm.quicktemplate.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * API基本信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("QUICK-TEMPLATE项目")
                .description("快速开发模版")
                .contact(new Contact("mingm", "", ""))
                .version("1.0.0")
                .build();
    }
}
