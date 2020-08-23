package com.skp.spring.data.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.skp.spring.data.repos")
@EnableTransactionManagement
@ComponentScan("com.skp.spring.data")
public class DataConfig {
}
