package br.com.alertabet.dto;

/**
 * DTO de resposta para autenticação.
 * Contém o token gerado após login bem-sucedido.
 *
 * @param token Token JWT retornado.
 */
public record TokenResponseDTO(String token) {}
