package br.com.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.votacao.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
