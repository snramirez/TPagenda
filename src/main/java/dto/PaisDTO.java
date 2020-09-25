package dto;

public class PaisDTO {
	
	private int idPais;
	private String nombrePais;
	
	public PaisDTO(int idPais, String nombrePais) {
		super();
		this.idPais = idPais;
		this.nombrePais = nombrePais;
	}
	
	public int getIdPais() {
		return idPais;
	}
	
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	
	public String getNombrePais() {
		return nombrePais;
	}
	
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	

}
