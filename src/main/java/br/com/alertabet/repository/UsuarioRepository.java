package br.com.alertabet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alertabet.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
