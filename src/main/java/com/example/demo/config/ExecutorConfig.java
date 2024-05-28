package com.example.demo.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableAsync
@Slf4j
public class ExecutorConfig {
    
    @Bean(name="singleThread")
    public Executor singleThreadExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.afterPropertiesSet();
        return executor;
    }

    @Bean(name="multiThread")
    public Executor multiThreadExecutor() {
        int cores = Runtime.getRuntime().availableProcessors();
        log.info("Number of threads deteected: " + cores);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(cores);
        executor.setMaxPoolSize(cores);
        executor.afterPropertiesSet();
        return executor;
    }

}
