package org.polytech.covidapi.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("org.polytech.spring.patient")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public PatientStore store(){
        return new PatientDataBase();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public PatientService patientService(PatientStore store){
        return new PatientService(null);
    }

    @PostConstruct
    public void init(){
        System.out.println("PatientDataBase - init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("PatientDataBase - destroy");
    }
    
}
