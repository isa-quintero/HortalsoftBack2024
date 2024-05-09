package com.hortalsoft.crosscutting.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean
    public ExceptionHandlingAspect exceptionHandlingAspect() {
        return new ExceptionHandlingAspect();
    }
}