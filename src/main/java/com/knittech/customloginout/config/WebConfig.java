/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.customloginout.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Sumit
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.knittech.customloginout")
public class WebConfig implements WebMvcConfigurer {
   
    @Bean
    public ViewResolver internalResourceViewResolver (){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
        return viewResolver;
    }
    
    
}
