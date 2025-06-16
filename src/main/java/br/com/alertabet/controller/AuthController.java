package br.com.alertabet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alertabet.dto.LoginDTO;
import br.com.alertabet.dto.TokenResponseDTO;
import br.com.alertabet.service.UsuarioService;

/**
 * Controlador responsável pela autenticação de usuários.
 * Exponde o endpoint de login.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Endpoint para login de usuários.
     *
     * @param loginDTO Objeto contendo e-mail e senha do usuário.
     * @return Token gerado em caso de autenticação bem-sucedida.
     */
    @PostMapping("/login")
    public TokenResponseDTO login(@RequestBody LoginDTO loginDTO) {
        return usuarioService.login(loginDTO);
    }
}
