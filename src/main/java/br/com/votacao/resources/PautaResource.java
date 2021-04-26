package br.com.votacao.resources;

import java.net.URI;
import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.votacao.domain.Pauta;
import br.com.votacao.domain.RunnableTask;
import br.com.votacao.domain.Usuario;
import br.com.votacao.domain.VotoEmPauta;
import br.com.votacao.dto.VotoDTO;
import br.com.votacao.enums.ResultadoVoto;
import br.com.votacao.service.PautaService;
import br.com.votacao.service.UsuarioService;
import br.com.votacao.service.VotoEmPautaService;

@RestController
@RequestMapping(value = "/pautas")
public class PautaResource {
	
	static final Logger log = LoggerFactory.getLogger(PautaResource.class);

    @Autowired
    PautaService pautaService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    VotoEmPautaService votoEmPautaService;

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Pauta>> listar() {
        return ResponseEntity.ok().body(pautaService.listar());
    }

    @RequestMapping(value  = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pauta> mostrarPauta(@PathVariable Integer id) {
        Pauta pauta = pautaService.buscarPauta(id);
        return ResponseEntity.ok().body(pauta);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pauta> editarPauta(@PathVariable Integer id, @RequestBody Pauta pauta) {
        Pauta findPauta = pautaService.editarPauta(id, pauta);

        return ResponseEntity.ok().body(findPauta);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> cadastrar (@RequestBody Pauta pauta) {
        Pauta novaPauta = pautaService.salvarPauta(pauta);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(novaPauta.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value  = "/{id}/iniciar-votacao", method = RequestMethod.GET)
    public ResponseEntity<Void> iniciarVotacao(@PathVariable Integer id) {
        Pauta pauta = pautaService.buscarPauta(id);
        pautaService.abrirVotacao(id);
        taskScheduler.schedule(
                new RunnableTask(pauta, pautaService),
                new Date(System.currentTimeMillis() + pauta.getTempoDeVotacao())
        );
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value  = "/{id}/votar", method = RequestMethod.POST)
    public ResponseEntity<Void> votar(@PathVariable Integer id, @RequestBody VotoDTO votoDTO) {
        Pauta pauta = pautaService.buscarPauta(votoDTO.getIdPauta());
        Usuario usuario = usuarioService.buscarUsuario(votoDTO.getIdUsuario());
        ResultadoVoto resultadoVoto = ResultadoVoto.toEnum(votoDTO.getStatusVoto());
        VotoEmPauta votoEmPauta = new VotoEmPauta(pauta, usuario, resultadoVoto);

        votoEmPautaService.votarNaPauta(votoEmPauta);

        return ResponseEntity.ok().build();
    }

}
