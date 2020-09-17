package persistencia.dao.interfaz;
import java.util.List;
import dto.DireccionDTO;

public interface DireccionDAO {
	
	public boolean insert(DireccionDTO direccion);
	
	public boolean delete(DireccionDTO direccion_a_borrar);
	
	public boolean update (DireccionDTO direccion_a_editar);
	
	public List<DireccionDTO> readAll(); 

}
