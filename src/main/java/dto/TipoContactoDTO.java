package dto;

public class TipoContactoDTO {
	
	private int idTipoContacto;
	private String nombreContacto;
	
	
	public TipoContactoDTO(int idTipoContacto, String nombreContacto) {
		this.idTipoContacto = idTipoContacto;
		this.nombreContacto = nombreContacto;
	}


	public int getIdTipoContacto() {
		return idTipoContacto;
	}


	public void setIdTipoContacto(int idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}


	public String getNombreTipoContacto() {
		return nombreContacto;
	}


	public void setNombreTipoContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	
	@Override
	public String toString() {
		return this.nombreContacto ;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipoContacto;
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
		TipoContactoDTO other = (TipoContactoDTO) obj;
		if (idTipoContacto != other.idTipoContacto)
			return false;
		return true;
	}

}
