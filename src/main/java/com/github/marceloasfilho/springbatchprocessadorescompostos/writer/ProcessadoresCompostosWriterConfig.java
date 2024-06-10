package com.github.marceloasfilho.springbatchprocessadorescompostos.writer;

import com.github.marceloasfilho.springbatchprocessadorescompostos.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadoresCompostosWriterConfig {
    @Bean
    public ItemWriter<Cliente> processadoresCompostosWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }
}
