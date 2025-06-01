package com.sopromadze.blogapi.config;

import com.graphqlify.extended.injected.InjectedParameter;
import com.graphqlify.extended.injected.InjectedParameterMapper;
import com.sopromadze.blogapi.security.UserPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.lang.reflect.Parameter;

@Configuration
public class GraphQLifyManualConfig {

    @Bean
    @Primary
    public InjectedParameterMapper injectedParameterMapper() {
        return new InjectedParameterMapper() {
            @Override
            protected <T> T mapInjectedParameter(Parameter parameter, InjectedParameter injectedParameter) {

                try {
                    Class<?> clazz = Class.forName(injectedParameter.getParameterType());
                    if (clazz.equals(UserPrincipal.class)) {
                        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                        if (authentication != null) {
                            Object principal = authentication.getPrincipal();
                            if (principal instanceof UserPrincipal) {
                                UserPrincipal userPrincipal = (UserPrincipal) principal;
                                return (T) userPrincipal;
                            }else {
                                System.out.println("Principal is not an instance of UserPrincipal");
                            }
                        }else{
                            System.out.println("Authentication object is null!");
                        }
                    }else {
                        System.out.println("Unknown injected parameter type: " + injectedParameter.getParameterType());
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                throw new RuntimeException("Didn't find mapping for injected parameter: " + injectedParameter);
            }
        };
    }
}

