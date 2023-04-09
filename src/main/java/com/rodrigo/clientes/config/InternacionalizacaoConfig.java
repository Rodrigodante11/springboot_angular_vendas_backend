package com.rodrigo.clientes.config;

import org.aspectj.apache.bcel.classfile.LocalVariable;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class InternacionalizacaoConfig {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource =  new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages"); // messages = messages.properties
        messageSource.setDefaultEncoding("ISO-8859-1"); // reconhecer padrao brasileiro acento e outros ...
        messageSource.setDefaultLocale( Locale.getDefault());

        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean(){ // objeto que faz a interpolacao entre as mensagens

        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
