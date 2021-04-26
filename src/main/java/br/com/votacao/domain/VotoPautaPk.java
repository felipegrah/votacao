package br.com.votacao.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VotoPautaPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "pauta_id")
	private Pauta pauta;

	@JsonIgnore
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@JsonIgnore
	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pauta == null) ? 0 : pauta.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		VotoPautaPk other = (VotoPautaPk) obj;
		if (pauta == null) {
			if (other.pauta != null)
				return false;
		} else if (!pauta.equals(other.pauta))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
