//package com.vvlhw.supermarket.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CrossConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")          //所有请求接口都支持跨域
//                .allowedOrigins("*")                    //允许探测请求的请求域
//                .allowedHeaders("*")                    //所有请求头都支持
//                .allowedMethods("*")                    //所有请求方法都支持
//                .allowCredentials(true)                 //允许携带cookie
//                .maxAge(3600);
//        /**
//         * 例如：put请求会先发送一个探测请求，探测服务器支不支持put请求，
//         * 但是没必要每次发送put请求前都要发送一个探测请求，
//         * 这个maxAge就是请求保存的时间，这个请求在maxAge时间内不需要发送探测请求
//         * allowCredentials选择发送ajax请求的时候是否把cookie带上
//         */
//    }
//}
