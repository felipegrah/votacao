package br.com.votacao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votacao.domain.Pauta;
import br.com.votacao.enums.ProgressoVotacao;
import br.com.votacao.repository.PautaRepository;
import br.com.votacao.service.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class PautaService {
	
	static final Logger log = LoggerFactory.getLogger(PautaService.class);

    @Autowired
    PautaRepository pautaRepository;

    public Pauta buscarPauta(Integer id) {
        Optional<Pauta> obj = pautaRepository.findById(id);
        return obj.orElseThrow(() -> {
        	log.error("Objeto não encontrado! Id " + id);
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                    + ", Tipo: " + Pauta.class.getName());
        });
    }

    public Pauta salvarPauta(Pauta pauta) {
        pautaRepository.save(pauta);
        return pauta;
    }

    public List<Pauta> listar() {
        return pautaRepository.findAll();
    }

    public Pauta editarPauta(Integer id, Pauta pauta) {
        Pauta pautaBD = buscarPauta(id);
        pauta.setId(pautaBD.getId());
        return pautaRepository.save(pauta);
    }

    public void abrirVotacao(Integer idPauta) {
        Pauta pautaEmVotacao = buscarPauta(idPauta);
        pautaEmVotacao.setSessaoStatus(ProgressoVotacao.EM_ANDAMENTO);
        pautaRepository.save(pautaEmVotacao);
    }

    public void finalizarVotacao(Pauta pauta) {
        Pauta pautaEmVotacao = buscarPauta(pauta.getId());
        pautaEmVotacao.setSessaoStatus(ProgressoVotacao.FINALIZADO);
        pautaRepository.save(pautaEmVotacao);
    }

}
