package edu.nf.shopping.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Achine
 * @date 2019/12/18
 */
@Configuration
@EnableSwagger2 //启用Swargger处理器
public class SwaggerConfig {

    //装配Docket配置对象，它是swagger的核心配置
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    /**
     * Api接口描述配置
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("管理员端接口文档")
                // 文档描述
                .description("管理员端API文档接入说明")
                //api说明网站
                .termsOfServiceUrl("https://github.com/nfyinteam/addiction-shopping")
                //Api版本
                .version("v1")
                .build();
    }
}
