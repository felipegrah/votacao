package br.com.votacao.dto;

public class VotoDTO {

    private Integer idPauta;
    private Integer idUsuario;
    private Integer statusVoto;

    public VotoDTO() {
    }

    public VotoDTO(Integer idPauta, Integer idUsuario, Integer statusVoto) {
        this.idPauta = idPauta;
        this.idUsuario = idUsuario;
        this.statusVoto = statusVoto;
    }

    public Integer getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Integer idPauta) {
        this.idPauta = idPauta;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getStatusVoto() {
        return statusVoto;
    }

    public void setStatusVoto(Integer statusVoto) {
        this.statusVoto = statusVoto;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPauta == null) ? 0 : idPauta.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((statusVoto == null) ? 0 : statusVoto.hashCode());
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
		VotoDTO other = (VotoDTO) obj;
		if (idPauta == null) {
			if (other.idPauta != null)
				return false;
		} else if (!idPauta.equals(other.idPauta))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (statusVoto == null) {
			if (other.statusVoto != null)
				return false;
		} else if (!statusVoto.equals(other.statusVoto))
			return false;
		return true;
	}
    
}
