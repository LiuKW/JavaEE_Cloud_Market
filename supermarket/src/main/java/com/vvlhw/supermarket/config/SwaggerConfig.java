package com.vvlhw.supermarket.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author VVlhw
 * @date 2020/7/6 - 9:26
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 分类模块
     */
    @Bean
    public Docket lhw(Environment environment) {
        Profiles of = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .groupName("分类模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vvlhw.supermarket.controller"))
                .apis(new Swaggerfilter())
                .paths(PathSelectors.ant("/supermarket/category/**"))
                .build();
    }


    /**
     * 评论模块
     */



    /**
     * 商品模块
     */
    @Bean
    public Docket kingwait2(Environment environment) {
        Profiles of = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .groupName("商品模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vvlhw.supermarket.controller"))
                .apis(new Swaggerfilter())
                .paths(PathSelectors.ant("/supermarket/good/**"))
                .build();
    }



    /**
     * 商品图片模块
     */
    @Bean
    public Docket lhw1(Environment environment) {
        Profiles of = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .groupName("图片模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vvlhw.supermarket.controller"))
                .apis(new Swaggerfilter())
                .paths(PathSelectors.ant("/supermarket/good-images/**"))
                .build();
    }


    /**
     * 用户地址模块
     */
    @Bean
    public Docket kingwait1(Environment environment) {
        Profiles of = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .groupName("用户地址模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vvlhw.supermarket.controller"))
                .apis(new Swaggerfilter())
                .paths(PathSelectors.ant("/supermarket/user-address/**"))
                .build();
    }


    /**
     * 用户模块
     */
    @Bean
    public Docket kingwait(Environment environment) {
        Profiles of = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .groupName("用户模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vvlhw.supermarket.controller"))
                .apis(new Swaggerfilter())
                .paths(PathSelectors.ant("/supermarket/user/**"))
                .build();
    }



    /**
     * 订单模块
     */
    @Bean
    public Docket zjh(Environment environment) {
        Profiles of = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .groupName("订单模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vvlhw.supermarket.controller"))
                .apis(new Swaggerfilter())
                .paths(PathSelectors.ant("/supermarket/user-order/**"))
                .build();
    }










    private ApiInfo apiInfo() {
        Contact contact = new Contact("梁汉伟", "https://vvlhw.com", "15362941982@163.com");
        return new ApiInfo(
                "UESTC_Supermarket的接口文档",
                "Stay Hungry Stay Foolish",
                "v1.0",
                "https://vvlhw.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );

    }



    /**
     *     一个只看有 @ApiOperation 的过滤器
     */
    private class Swaggerfilter implements Predicate<RequestHandler> {

        @Override
        public boolean apply(@NullableDecl RequestHandler requestHandler) {
            if (requestHandler.findAnnotation(ApiOperation.class).isPresent()) {
                return true;
            }
            return false;
        }
    }
}
