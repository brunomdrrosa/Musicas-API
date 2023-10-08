package br.com.bruno.musicas_a_p_i.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("br.com.bruno.musicas_a_p_i.domain")
@EnableJpaRepositories("br.com.bruno.musicas_a_p_i.repos")
@EnableTransactionManagement
public class DomainConfig {
}
