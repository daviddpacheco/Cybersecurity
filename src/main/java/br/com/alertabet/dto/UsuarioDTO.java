package br.com.alertabet.dto;

/**
 * DTO que representa os dados do usuário.
 *
 * @param id    Identificador único do usuário.
 * @param nome  Nome do usuário.
 * @param email Email do usuário.
 */
public record UsuarioDTO(Long id, String nome, String email) {}
