package br.com.alertabet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alertabet.model.Usuario;

/**
 * Interface de repositório para a entidade {@link Usuario}.
 * <p>
 * Responsável por operações de persistência no banco de dados relacionadas à tabela de usuários.
 * Herda os métodos básicos do {@link JpaRepository}, como salvar, deletar, buscar por ID, etc.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca um usuário pelo campo de e-mail.
     *
     * @param email o e-mail do usuário a ser buscado
     * @return um {@link Optional} contendo o usuário, caso encontrado
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * VULNERABILIDADE (SQL INJECTION): Busca um usuário concatenando strings na query.
     * Este método é inseguro e foi criado para ser detectado por ferramentas SAST.
     * @param email E-mail do usuário.
     * @return um Optional contendo o usuário, caso encontrado.
     */
    @Query(value = "SELECT * FROM Usuario WHERE email = :email", nativeQuery = true)
    Optional<Usuario> findByEmailVulnerable(@Param("email") String email);
}