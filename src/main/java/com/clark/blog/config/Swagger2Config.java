package com.clark.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2019/8/21 19:50
 * @Description:
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 注册Swagger Docket Bean
     * @return
     */
    @Bean
    public Docket createRestApi() {
        //添加head参数配置
        ParameterBuilder tokenParameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        Parameter tokenParameter = tokenParameterBuilder.name("Authorization").description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parameters.add(tokenParameter);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.clark.blog.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters);
    }

    /**
     * 获取ApiInfo对象
     * @return
     */
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("BLOG API")
                .description("后台服务API")
                .termsOfServiceUrl("api.clarkrao.top")
                .version("1.0")
                .build();
    }
}
