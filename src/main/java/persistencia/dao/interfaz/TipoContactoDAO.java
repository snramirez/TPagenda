package persistencia.dao.interfaz;

import java.util.List;
import dto.TipoContactoDTO;

public interface TipoContactoDAO {
	public boolean insert(TipoContactoDTO tipoContacto);
	
	public boolean delete(TipoContactoDTO tipoContactoEliminar);
	
	public boolean update (TipoContactoDTO tipoContactoEditar);
	
	public List<TipoContactoDTO> readAll(); 

}
