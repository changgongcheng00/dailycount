package com.dailycount.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @ClassName WebMnvConfig
 * @Description TODO
 * @Author cheng
 * @Date 2019/1/2 13:14
 **/
@Configuration
public class WebMnvConfig implements WebMvcConfigurer {

    @Autowired
    private WebInterceptor webInterceptor;
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


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/toLogin").setViewName("login");
//        registry.addViewController("/index").setViewName("index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(webInterceptor).addPathPatterns("/**").excludePathPatterns(
           "/toLogin","/login","/error","**/swagger-ui.html","/img/**", "/css/**", "/js/**","/font/**","/ico/**");
    }
}

