package br.com.votacao.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Usuario implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "id.usuario")
    private Set<VotoEmPauta> votos = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "usuarios")
    private List<Pauta> pautas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Set<VotoEmPauta> getVotos() {
        return votos;
    }

    public void setVotos(Set<VotoEmPauta> votos) {
        this.votos = votos;
    }

    @JsonIgnore
    public List<Pauta> getPautasDoVoto() {
        List<Pauta> pautaX = new ArrayList<>();
        votos.stream().forEach(voto -> pautaX.add(voto.getPauta()) );
        return pautaX;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Pauta> getPautas() {
        return pautas;
    }

    public void setPautas(List<Pauta> pautas) {
        this.pautas = pautas;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pautas == null) ? 0 : pautas.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pautas == null) {
			if (other.pautas != null)
				return false;
		} else if (!pautas.equals(other.pautas))
			return false;
		if (votos == null) {
			if (other.votos != null)
				return false;
		} else if (!votos.equals(other.votos))
			return false;
		return true;
	}
    
    
}
