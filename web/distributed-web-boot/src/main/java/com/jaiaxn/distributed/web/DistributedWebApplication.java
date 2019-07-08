package com.jaiaxn.distributed.web;

import com.jaiaxn.distributed.web.config.intercepors.LoginInterceptor;
import com.jaiaxn.distributed.web.config.intercepors.PermissionInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
@SpringBootApplication
@Slf4j
@EnableCaching
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DistributedWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DistributedWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        log.info("start--SpringBoot---web");
        return builder.sources(DistributedWebApplication.class);
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WorkFlowWebMvcConfigurer();
    }

    class WorkFlowWebMvcConfigurer implements WebMvcConfigurer {

        @Bean
        public LoginInterceptor loginInterceptor() {
            return new LoginInterceptor();
        }

        @Bean
        public PermissionInterceptor permissionInterceptor() {
            return new PermissionInterceptor();
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/**").addResourceLocations("/");
        }

        @Override
        public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

        }

        @Override
        public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

        }

        @Override
        public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

        }

        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

        }

        @Override
        public void addFormatters(FormatterRegistry formatterRegistry) {

        }

        @Override
        public void addInterceptors(InterceptorRegistry interceptorRegistry) {
            interceptorRegistry.addInterceptor(loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
            interceptorRegistry.addInterceptor(permissionInterceptor()).addPathPatterns("/**");
        }

        /**
         * 添加跨域请求全局配置
         */
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**")
                    .allowedMethods("PUT", "DELETE","GET","POST");
        }

        @Override
        public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

        }

        @Override
        public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

        }

        @Override
        public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

        }

        @Override
        public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

        }

        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

        }

        @Override
        public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

        }

        @Override
        public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

        }

        @Override
        public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

        }

        @Override
        public Validator getValidator() {
            return null;
        }

        @Override
        public MessageCodesResolver getMessageCodesResolver() {
            return null;
        }
    }
}
