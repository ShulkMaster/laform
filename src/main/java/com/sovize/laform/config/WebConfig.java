package com.sovize.laform.config;

import com.sovize.laform.domain.StringValidator;
import com.sovize.laform.domain.StudentForm;
import com.sovize.laform.domain.StudentValidator;
import com.sovize.laform.interfaces.IValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class WebConfig {

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver vf = new ThymeleafViewResolver();
        vf.setTemplateEngine(templateEngine());
        vf.setCharacterEncoding("UTF-8");
        return vf;
    }

    @Bean
    public ClassLoaderTemplateResolver templateResolver() {
        ClassLoaderTemplateResolver tr = new ClassLoaderTemplateResolver();
        tr.setPrefix("templates/");
        tr.setSuffix(".html");
        tr.setTemplateMode("HTML");
        tr.setCharacterEncoding("UTF-8");
        return tr;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine te = new SpringTemplateEngine();
        te.setTemplateResolver(templateResolver());
        return te;
    }

    public void addResourceHanler(ResourceHandlerRegistry reg) {
        reg.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
        reg.addResourceHandler("webjars/**")
                .addResourceLocations("/webjars/");
    }

    @Bean
    public IValidator<StudentForm> getStudentValidator(){
        return new StudentValidator();
    }
}
