package br.com.votacao.domain;


import java.util.Date;

import br.com.votacao.service.PautaService;

public class RunnableTask implements Runnable {


    private  PautaService pautaService;

    private Pauta pauta;

    public RunnableTask(Pauta pauta, PautaService pautaService) {
        this.pauta = pauta;
        this.pautaService = pautaService;
    }

    @Override
    public void run() {
        pautaService.finalizarVotacao(pauta);
        System.out.println(new Date() + " Finalizando Votação "+ pauta.toString());
    }
}
