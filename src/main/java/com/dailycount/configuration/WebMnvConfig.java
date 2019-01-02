package com.dailycount.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebMnvConfig
 * @Description TODO
 * @Author cheng
 * @Date 2019/1/2 13:14
 **/
@Configuration
public class WebMnvConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        // 允许跨域访问资源定义： /dailycount/ 所有资源
        corsRegistry.addMapping("/dailycount/**")
            // 只允许本地的9000端口访问
            .allowedOrigins("*", "https://www.baidu.com")
            // 允许发送Cookie
            .allowCredentials(true)
            // 允许所有方法
            .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
    }
}

