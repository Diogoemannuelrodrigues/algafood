package br.com.estudos.algaworksESR.service;

import br.com.estudos.algaworksESR.entidade.Usuario;
import br.com.estudos.algaworksESR.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario buscarUsuario(UUID id) {
        Optional<Usuario> cliente = usuarioRepository.findById(id);
        return cliente.orElse(null);
    }

    public Usuario salvarUsuario (Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(UUID id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario alterarUsuario(Usuario usuario) {
        Optional<Usuario> usu = usuarioRepository.findById(usuario.getId());
        return usuarioRepository.save(usu.get());
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
