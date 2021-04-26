package br.com.votacao.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.votacao.enums.ResultadoVoto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "VOTOS_USUARIOS_EM_PAUTAS")
public class VotoEmPauta implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
    @EmbeddedId
    private VotoPautaPk id = new VotoPautaPk();

    private ResultadoVoto statusVoto;

    public VotoEmPauta() {
    }

    public VotoEmPauta(Pauta pauta, Usuario usuario, ResultadoVoto statusVoto) {
        this.id.setPauta(pauta);
        this.id.setUsuario(usuario);
        this.statusVoto = statusVoto;
    }

    public Usuario getUsuario() {
        return id.getUsuario();
    }

    public Pauta getPauta() {
        return id.getPauta();
    }

    public VotoPautaPk getId() {
        return id;
    }

    public void setId(VotoPautaPk id) {
        this.id = id;
    }

    public ResultadoVoto getStatusVoto() {
        return statusVoto;
    }

    public void setStatusVoto(ResultadoVoto statusVoto) {
        this.statusVoto = statusVoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VotoEmPauta)) return false;
        VotoEmPauta that = (VotoEmPauta) o;
        return getId().equals(that.getId()) && getStatusVoto() == that.getStatusVoto();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatusVoto());
    }
}
