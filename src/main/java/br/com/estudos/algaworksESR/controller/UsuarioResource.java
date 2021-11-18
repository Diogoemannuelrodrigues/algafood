package br.com.estudos.algaworksESR.controller;

import br.com.estudos.algaworksESR.entidade.Usuario;
import br.com.estudos.algaworksESR.repository.UsuarioRepository;
import br.com.estudos.algaworksESR.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository repo;

    @PostMapping()
    public Usuario save(@RequestBody Usuario usuario){
        return repo.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable("id") String usuarioId){
        return repo.getUsuario(usuarioId);
    }

    @DeleteMapping("/{id}")
    public String deleteUsuario(@PathVariable("id") String usuarioId){
        return repo.delete(usuarioId);
    }

    @PutMapping("/{id}")
    public String alterarUsuario(@PathVariable("id") String usuarioId, @RequestBody Usuario usuario){
    return repo.update(usuarioId, usuario);
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Usuario> findUsuario(@PathVariable UUID id){
//        Usuario usuario = service.buscarUsuario(id);
//        return ResponseEntity.ok().body(usuario);
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Void> saveCliente (@RequestBody Usuario usuario){
//        Usuario usuarioNew = service.salvarUsuario(usuario);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(usuario.getId())
//                .toUri();
//        return ResponseEntity.created(uri).build();
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Usuario> listarClientes(){
//        List<Usuario> usuarios = service.listarUsuarios();
//        return usuarios;
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Usuario> alterarCliente (@RequestBody Usuario usuario){
//        Usuario cli = service.alterarUsuario(usuario);
//        return ResponseEntity.ok().body(cli);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Usuario> deletaProduto(@PathVariable UUID id){
//        service.deletarUsuario(id);
//        return ResponseEntity.noContent().build();
//    }

}
