package br.com.votacao.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.votacao.enums.ProgressoVotacao;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Pauta implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(name = "nome_pauta")
    private String nomePauta;

    @Column(name = "sessao_status")
    private ProgressoVotacao sessaoStatus = ProgressoVotacao.NOVA;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime tempoDeVotacao = LocalTime.of(0,1);

    @ManyToMany
    @JoinTable(name = "PAUTA_USUARIO",
        joinColumns = @JoinColumn(name = "pauta_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "id.pauta")
    private Set<VotoEmPauta> votos = new HashSet<>();

    public Pauta() {}

    public Pauta (String nomePauta ) {
        this.nomePauta = nomePauta;
    }

    public Pauta (String nomePauta, LocalTime tempoDeVotacao) {
        this.nomePauta = nomePauta;
        this.tempoDeVotacao = tempoDeVotacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomePauta() {
        return nomePauta;
    }

    public void setNomePauta(String nomePauta) {
        this.nomePauta = nomePauta;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ProgressoVotacao getSessaoStatus() {
        return sessaoStatus;
    }

    public void setSessaoStatus(ProgressoVotacao sessaoStatus) {
        this.sessaoStatus = sessaoStatus;
    }

    public Long getTempoDeVotacao() {
        long h = tempoDeVotacao.getHour();
        long m = tempoDeVotacao.getMinute();
        long s = tempoDeVotacao.getSecond();
        return  ((h * 3600) + (m * 60) + s) * 1000;
    }

    public void setTempoDeVotacao(LocalTime tempoDeVotacao) {
        this.tempoDeVotacao = tempoDeVotacao;
    }

    @JsonIgnore
    public Set<VotoEmPauta> getVotos() {
        return votos;
    }

    public void setVotos(Set<VotoEmPauta> votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + nomePauta + '\'' +
                ", status='" + sessaoStatus.toString() + '\'' +
                '}';
    }
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomePauta == null) ? 0 : nomePauta.hashCode());
		result = prime * result + ((sessaoStatus == null) ? 0 : sessaoStatus.hashCode());
		result = prime * result + ((tempoDeVotacao == null) ? 0 : tempoDeVotacao.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		result = prime * result + ((votos == null) ? 0 : votos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pauta other = (Pauta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomePauta == null) {
			if (other.nomePauta != null)
				return false;
		} else if (!nomePauta.equals(other.nomePauta))
			return false;
		if (sessaoStatus != other.sessaoStatus)
			return false;
		if (tempoDeVotacao == null) {
			if (other.tempoDeVotacao != null)
				return false;
		} else if (!tempoDeVotacao.equals(other.tempoDeVotacao))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		if (votos == null) {
			if (other.votos != null)
				return false;
		} else if (!votos.equals(other.votos))
			return false;
		return true;
	}
    
    
    
    
}
