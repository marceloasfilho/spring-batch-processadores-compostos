package com.github.marceloasfilho.springbatchprocessadorescompostos.processor;

import com.github.marceloasfilho.springbatchprocessadorescompostos.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ProcessadoresCompostosProcessorConfig {
    private final Set<String> emails = new HashSet<>();

    @Bean
    public ItemProcessor<Cliente, Cliente> processadoresCompostosProcessor() throws Exception {
        return new CompositeItemProcessorBuilder<Cliente, Cliente>()
                .delegates(beanValidatingItemProcessor(), validatingItemProcessor())
                .build();
    }

    private BeanValidatingItemProcessor<Cliente> beanValidatingItemProcessor() throws Exception {
        BeanValidatingItemProcessor<Cliente> beanValidatingItemProcessor = new BeanValidatingItemProcessor<>();
        beanValidatingItemProcessor.setFilter(true);
        beanValidatingItemProcessor.afterPropertiesSet();
        return beanValidatingItemProcessor;
    }

    private ValidatingItemProcessor<Cliente> validatingItemProcessor() {
        ValidatingItemProcessor<Cliente> processor = new ValidatingItemProcessor<>();
        processor.setValidator(emailValidatingItemProcessor());
        processor.setFilter(true);
        return processor;
    }

    private Validator<Cliente> emailValidatingItemProcessor() {
        return cliente -> {
            if (this.emails.contains(cliente.email())) {
                throw new ValidationException("Email já cadastrado: " + cliente.email());
            }
            this.emails.add(cliente.email());
        };
    }
}
