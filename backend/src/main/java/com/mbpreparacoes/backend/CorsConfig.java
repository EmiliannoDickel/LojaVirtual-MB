package com.mbpreparacoes.backend;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    public class CorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**")  // Aplique a configuração apenas para as rotas da API
                    .allowedOrigins("http://localhost:3000") // Substitua pelo endereço do seu front-end
                    .allowedMethods("GET", "POST", "PUT", "DELETE") // Permita os métodos HTTP que você utiliza
                    .allowedHeaders("*") // Permite todos os cabeçalhos
                    .allowCredentials(true); // Permite o envio de cookies (se necessário)
        }
    }

