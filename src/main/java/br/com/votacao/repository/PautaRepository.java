package br.com.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.votacao.domain.Pauta;

public interface PautaRepository  extends JpaRepository<Pauta, Integer> {
}
