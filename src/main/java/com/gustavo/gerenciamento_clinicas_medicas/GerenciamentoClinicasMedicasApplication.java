package com.gustavo.gerenciamento_clinicas_medicas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Gerenciamento Clínicas Médicas",
                version = "1.0",
                description = "API para gerenciamento de clínicas médicas"
        )
)
public class GerenciamentoClinicasMedicasApplication {

    public static void main(String[] args) {
        SpringApplication.run(GerenciamentoClinicasMedicasApplication.class, args);
    }

}
