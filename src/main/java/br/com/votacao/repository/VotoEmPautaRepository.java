package br.com.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.votacao.domain.VotoEmPauta;

public interface VotoEmPautaRepository extends JpaRepository<VotoEmPauta, Integer> {
}
