package com.example.blog;

import com.example.blog.util.LocalDateFormatter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BlogApplication.class);
    }

    public void addFormatters(FormatterRegistry registry){
        LocalDateFormatter formatter = new LocalDateFormatter("yyyy-MM-dd");
        registry.addFormatter(formatter);
    }

}
