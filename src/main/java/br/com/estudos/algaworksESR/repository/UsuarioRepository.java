package br.com.estudos.algaworksESR.repository;

import br.com.estudos.algaworksESR.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, UUID>{
}
