package com.github.marceloasfilho.springbatchprocessadorescompostos.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadoresCompostosJobConfig {
    @Bean
    public Job processadoresCompostosJob(Step processadoresCompostosStep,
                                       JobRepository jobRepository) {
        return new JobBuilder("processadoresCompostosJob", jobRepository)
                .start(processadoresCompostosStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
