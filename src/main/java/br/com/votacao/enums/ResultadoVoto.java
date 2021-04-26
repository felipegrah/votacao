package br.com.votacao.enums;

public enum ResultadoVoto {

    SIM(1, "Sim"),
    NAO(0, "Não");

	private int cod;
    private String descricao;

    private ResultadoVoto(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ResultadoVoto toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for (ResultadoVoto x : ResultadoVoto.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id tipo de voto inválido " + cod);
    }
}
