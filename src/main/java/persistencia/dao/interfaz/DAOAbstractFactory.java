package persistencia.dao.interfaz;


public interface DAOAbstractFactory 
{
	public PersonaDAO createPersonaDAO();
	
	public DireccionDAO createDireccionDAO();
	
	public TipoContactoDAO createTipoContactoDAO();
	
	public PaisProvLocDAO createPaisProvLocDAO();
}
