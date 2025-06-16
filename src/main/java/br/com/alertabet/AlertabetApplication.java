package br.com.alertabet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação AlertaBet.
 * Responsável por inicializar o Spring Boot.
 */
@SpringBootApplication
public class AlertabetApplication {

    /**
     * Método principal que inicia a aplicação Spring Boot.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        SpringApplication.run(AlertabetApplication.class, args);
    }
}
