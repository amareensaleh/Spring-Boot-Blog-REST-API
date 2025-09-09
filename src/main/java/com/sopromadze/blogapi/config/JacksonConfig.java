package com.sopromadze.blogapi.config;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public Hibernate5Module hibernateModule() {
        Hibernate5Module m = new Hibernate5Module();
        // EITHER: only serialize the id when a lazy association isn't loaded
        m.enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
        // OR (careful: can cause N+1): force-load lazies during serialization
        // m.enable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
        return m;
    }
}
