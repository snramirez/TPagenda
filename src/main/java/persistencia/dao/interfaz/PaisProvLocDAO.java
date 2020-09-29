package persistencia.dao.interfaz;

import java.util.List;
import dto.LocalidadDTO;
import dto.PaisDTO;
import dto.ProvinciaDTO;

public interface PaisProvLocDAO {
	
	public boolean insertPais(PaisDTO pais);
	
	public boolean insertProvincia(ProvinciaDTO provincia);
	
	public boolean insertLocalidad(LocalidadDTO localidad);
	
	
	public boolean deletePais(PaisDTO pais_a_borrar);
	
	public boolean deleteProvincia(ProvinciaDTO provincia_a_borrar);
	
	public boolean deleteLocalidad(LocalidadDTO localidad_a_borrar);
	
	
	public boolean updatePais (PaisDTO pais_a_editar);
	
	public boolean updateProvincia (ProvinciaDTO provincia_a_editar);
	
	public boolean updateLocalidad (LocalidadDTO localidad_a_editar);
	
	
	public List<PaisDTO> readAllPais(); 
	
	public List<ProvinciaDTO> readAllProvincia(); 
	
	public List<LocalidadDTO> readAllLocalidad(); 
	
	//public DireccionDTO lastInsert();

}
