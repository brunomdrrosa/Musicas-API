package br.com.bruno.musicas_a_p_i;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class MusicasAPIApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MusicasAPIApplication.class, args);
    }

}
