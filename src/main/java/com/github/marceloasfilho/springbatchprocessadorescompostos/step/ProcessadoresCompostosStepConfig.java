package com.github.marceloasfilho.springbatchprocessadorescompostos.step;

import com.github.marceloasfilho.springbatchprocessadorescompostos.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ProcessadoresCompostosStepConfig {
    @Bean
    public Step processadoresCompostosStep(
            ItemReader<Cliente> processadoresCompostosReader,
            ItemProcessor<Cliente, Cliente> processadoresCompostosProcessor,
            ItemWriter<Cliente> processadoresCompostosWriter,
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager
    ) {
        return new StepBuilder("processadoresCompostosStep", jobRepository)
                .<Cliente, Cliente>chunk(1, transactionManager)
                .reader(processadoresCompostosReader)
                .processor(processadoresCompostosProcessor)
                .writer(processadoresCompostosWriter)
                .build();
    }
}
