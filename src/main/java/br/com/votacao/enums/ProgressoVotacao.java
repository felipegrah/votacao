package br.com.votacao.enums;

public enum ProgressoVotacao {
	
    NOVA(0, "Nova"),
    EM_ANDAMENTO(1, "Sessão em andamento"),
    FINALIZADO(2, "Sessão finalizada");

    private int cod;
    private String descricao;

    private ProgressoVotacao(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ProgressoVotacao toEnum (Integer cod) {
        if(cod == null) {
            return null;
        }

        for (ProgressoVotacao x : ProgressoVotacao.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id tipo de voto inválido " + cod);
    }
}
