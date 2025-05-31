package com.sopromadze.blogapi.config;

import java.lang.reflect.Parameter;

import com.graphqlify.extended.injected.InjectedParameter;
import com.graphqlify.extended.injected.InjectedParameterMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLifyManualConfig {

    @Bean
    public InjectedParameterMapper injectedParameterMapper() {
        return new InjectedParameterMapper() {
            @Override
            protected <T> T mapInjectedParameter(Parameter parameter, InjectedParameter injectedParameter) {
                return null;
            }
        };
    }
}

