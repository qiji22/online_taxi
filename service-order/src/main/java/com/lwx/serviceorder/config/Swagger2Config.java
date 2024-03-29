package com.lwx.serviceorder.config;

import org.springframework.beans.factory.annotation.Value;
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
 * @Author: MR_LWX
 * @CreateTime: 2024-01-29  10:43
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {

    //访问地址：http://localhost:10086/swagger-ui.html
//    @Value("${server.localhost.flag}")
//    private String flag;
//
//    boolean of = flag.equals("dev");

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                //方式一、二都可接入
                .apiInfo(apiInfo())
                //配置是否启用Swagger，如果是false,在浏览器将无法访问
                .enable(true)
//                .enable(of)
                // 通过.select()方法，去配置扫描接口
                .select()
                //自行修改为自己项目下的controller路径，RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.lwx.serviceorder.controller"))
                //配置如何通过path过滤，我这里是获取全部
                .paths(PathSelectors.any())
                .build();
    }

    //方式一
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-api文档")
                .description("swagger接入教程")
                //服务条款网址
                .version("1.0")
                .build();
    }

}
