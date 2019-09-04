package com.nanrui.dwyy.config;

import com.nanrui.dwyy.component.LoginHandleInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebMvcConfigura
 * @Description TODO
 * @Author ZPL
 * @Date 2019/4/15 11:31
 * @Version 1.0
 **/
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("new_file2_全国");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源：*.css *.js  SpringBoot已经做好了静态资源映射
                System.out.println("进入拦截器");
                registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**");
            }
        };
        return adapter;
    }

}
