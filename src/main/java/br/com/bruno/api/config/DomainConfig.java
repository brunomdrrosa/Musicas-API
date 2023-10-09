package br.com.bruno.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("br.com.bruno.api.domain")
@EnableJpaRepositories("br.com.bruno.api.repos")
@EnableTransactionManagement
public class DomainConfig {
}
