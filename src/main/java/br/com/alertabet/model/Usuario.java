package br.com.alertabet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa um usuário no sistema.
 * Contém informações básicas como nome, e-mail e senha.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    /**
     * Identificador único do usuário (chave primária).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do usuário.
     */
    private String nome;

    /**
     * Endereço de e-mail do usuário.
     */
    private String email;

    /**
     * Senha do usuário.
     */
    private String senha;
}
