package br.com.alertabet.dto;

/**
 * DTO para autenticação de usuários.
 * Contém os dados necessários para o login: e-mail e senha.
 *
 * @param email E-mail do usuário.
 * @param senha Senha do usuário.
 */
public record LoginDTO(String email, String senha) {}
