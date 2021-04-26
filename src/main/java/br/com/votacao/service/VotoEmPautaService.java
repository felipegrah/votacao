package br.com.votacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votacao.domain.VotoEmPauta;
import br.com.votacao.repository.VotoEmPautaRepository;

@Service
public class VotoEmPautaService {

    @Autowired
    VotoEmPautaRepository votoEmPautaRepository;

    public void votarNaPauta(VotoEmPauta votoPauta) {
        votoEmPautaRepository.save(votoPauta);
    }
}
