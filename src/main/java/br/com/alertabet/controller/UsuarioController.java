package br.com.alertabet.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alertabet.dto.LoginDTO;
import br.com.alertabet.dto.TokenResponseDTO;
import br.com.alertabet.dto.UsuarioDTO;
import br.com.alertabet.service.UsuarioService;

/**
 * Controlador responsável pelos endpoints relacionados aos usuários.
 */
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    /**
     * Cria um novo usuário.
     *
     * @param dto Dados do usuário a ser criado.
     * @return Usuário criado com status 201.
     */
    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@RequestBody UsuarioDTO dto) {
        UsuarioDTO criado = service.criar(dto);
        return ResponseEntity.status(201).body(criado);
    }

    /**
     * Lista todos os usuários cadastrados.
     *
     * @return Lista de usuários.
     */
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    /**
     * Atualiza os dados de um usuário pelo ID.
     *
     * @param id  ID do usuário a ser atualizado.
     * @param dto Novos dados do usuário.
     * @return Usuário atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        UsuarioDTO atualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    /**
     * Exclui um usuário pelo ID.
     *
     * @param id ID do usuário a ser excluído.
     * @return Resposta com status 204 (sem conteúdo).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Realiza o login e gera um token de autenticação.
     *
     * @param dto Dados de login (e-mail e senha).
     * @return Token JWT gerado.
     */
    @PostMapping("/auth/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginDTO dto) {
        return ResponseEntity.ok(service.login(dto));
    }
}
