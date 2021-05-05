package com.clinic.provider.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: majunjie
 * @Date: 2021年1月28日$ 10点05分$
 * @Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger2.enable}")
    private boolean swagger2Enable;

    /**
     * 通过 createRestApi函数来构建一个DocketBean
     */
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //是否启用swagger2
                .enable(swagger2Enable)
                .apiInfo(apiInfo())
                .select()
                //控制暴露出去的路径下的实例
                // 如果某个接口不想暴露,可以使用以下注解
                //@ApiIgnore 该接口就不会暴露在 swagger2 的页面下
                .apis(RequestHandlerSelectors.basePackage("com.clinic.provider"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot Swagger2 构建RESTful API")
                //条款地址
                .termsOfServiceUrl("http://localhost:8080/")
                .license("License Version 1.0")
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}
