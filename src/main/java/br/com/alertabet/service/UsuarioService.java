package br.com.alertabet.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.alertabet.dto.LoginDTO;
import br.com.alertabet.dto.TokenResponseDTO;
import br.com.alertabet.dto.UsuarioDTO;
import br.com.alertabet.model.Usuario;
import br.com.alertabet.repository.UsuarioRepository;

/**
 * Serviço responsável pela lógica de negócios relacionada aos usuários.
 */
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    /**
     * Construtor do serviço de usuários.
     *
     * @param repository repositório de usuários
     */
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    /**
     * Cria um novo usuário com uma senha padrão.
     *
     * @param dto objeto com nome e e-mail do usuário
     * @return o usuário criado com ID
     */
    public UsuarioDTO criar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha("123"); // Senha padrão

        Usuario salvo = repository.save(usuario);
        return new UsuarioDTO(salvo.getId(), salvo.getNome(), salvo.getEmail());
    }

    /**
     * Lista todos os usuários cadastrados.
     *
     * @return lista de usuários no formato DTO
     */
    public List<UsuarioDTO> listar() {
        return repository.findAll()
                .stream()
                .map(u -> new UsuarioDTO(u.getId(), u.getNome(), u.getEmail()))
                .collect(Collectors.toList());
    }

    /**
     * Atualiza os dados de um usuário existente.
     *
     * @param id  identificador do usuário a ser atualizado
     * @param dto dados atualizados
     * @return o usuário após atualização
     */
    public UsuarioDTO atualizar(Long id, UsuarioDTO dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());

        Usuario atualizado = repository.save(usuario);
        return new UsuarioDTO(atualizado.getId(), atualizado.getNome(), atualizado.getEmail());
    }

    /**
     * Exclui um usuário com base no ID informado.
     *
     * @param id do usuário a ser excluído
     */
    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        repository.deleteById(id);
    }

    /**
     * Realiza o login verificando e-mail e senha.
     *
     * @param loginDTO credenciais de acesso
     * @return token fictício de autenticação
     */
    public TokenResponseDTO login(LoginDTO loginDTO) {
        // A lógica de login agora usa o método vulnerável para demonstração.
        Optional<Usuario> usuario = repository.findByEmailVulnerable(loginDTO.email());

        if (usuario.isPresent() && usuario.get().getSenha().equals(loginDTO.senha())) {
            return new TokenResponseDTO("fake-jwt-token");
        }

        throw new RuntimeException("Credenciais inválidas");
    }
}