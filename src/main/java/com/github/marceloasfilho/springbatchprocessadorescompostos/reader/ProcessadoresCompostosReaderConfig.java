package com.github.marceloasfilho.springbatchprocessadorescompostos.reader;

import com.github.marceloasfilho.springbatchprocessadorescompostos.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ProcessadoresCompostosReaderConfig {
    @Bean
    @StepScope
    public FlatFileItemReader<Cliente> processadoresCompostosReader(
            @Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("processadoresCompostosReader")
                .resource(arquivoClientes)
                .delimited()
                .names("nome", "idade", "email")
                .targetType(Cliente.class)
                .build();
    }
}
