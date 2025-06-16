package br.com.alertabet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.alertabet.dto.UsuarioDTO;
import br.com.alertabet.model.Usuario;
import br.com.alertabet.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioDTO> listar() {
        return repository.findAll().stream()
                .map(u -> new UsuarioDTO(u.getId(), u.getNome(), u.getEmail()))
                .toList();
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }
}
