package persistencia.dao.interfaz;

import java.util.List;
import dto.PaisProvLocDTO;

public interface PaisProvLocDAO {
	
	public boolean insert(PaisProvLocDTO pais);
	
	
	public boolean deletePais(PaisProvLocDTO pais_a_borrar);
	
	public boolean deleteProvincia(PaisProvLocDTO provincia_a_borrar);
	
	public boolean deleteLocalidad(PaisProvLocDTO localidad_a_borrar);
	
	
	public boolean updatePais (PaisProvLocDTO pais_a_editar, String nuevo_pais);
	
	public boolean updateProvincia (PaisProvLocDTO provincia_a_editar, String nueva_provincia);
	
	public boolean updateLocalidad (PaisProvLocDTO localidad_a_editar, String nueva_localidad);
	
	
	public List<PaisProvLocDTO> readAll(); 
	

	

}
