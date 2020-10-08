package dto;

public class PaisProvLocDTO {
	
	private int idPaisProvLoc;
	private String pais;
	private String provincia;
	private String localidad;
	
	public PaisProvLocDTO(int idPaisProvLoc, String pais, String provincia, String localidad) {
		this.idPaisProvLoc = idPaisProvLoc;
		this.pais = pais;
		this.provincia = provincia;
		this.localidad = localidad;
	}

	public int getIdPaisProvLoc() {
		return idPaisProvLoc;
	}

	public void setIdPaisProvLoc(int idPaisProvLoc) {
		this.idPaisProvLoc = idPaisProvLoc;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	

}
