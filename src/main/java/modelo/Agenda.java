package modelo;

import java.util.List;

import dto.DireccionDTO;
import dto.PaisProvLocDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DireccionDAO;
import persistencia.dao.interfaz.PaisProvLocDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;


public class Agenda 
{
	private PersonaDAO persona;
	private DireccionDAO dir;
	private TipoContactoDAO tipocont;
	private PaisProvLocDAO paisProvLoc;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
		this.dir = metodo_persistencia.createDireccionDAO();
		this.tipocont = metodo_persistencia.createTipoContactoDAO();
		this.paisProvLoc = metodo_persistencia.createPaisProvLocDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar);
	}
	
	public void editarPersona(PersonaDTO persona_a_editar)
	{
		this.persona.update(persona_a_editar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}

	public void agregarDireccion(DireccionDTO direccion) 
	{
		this.dir.insert(direccion);
	}
	
	public List<DireccionDTO> obtenerDirecciones () 
	{
		return this.dir.readAll();
	}
	
	public DireccionDTO ultimaDireccion() {
		return this.dir.lastInsert();
	}

	public void agregarTipoContacto(TipoContactoDTO tipo) {
		this.tipocont.insert(tipo);
	}
	
	public void borrarTipoContacto(TipoContactoDTO tipo_a_borrar)
	{
		this.tipocont.delete(tipo_a_borrar);
	}
	
	public void editarTipoContacto(TipoContactoDTO tipo_a_editar)
	{
		this.tipocont.update(tipo_a_editar);
	}
	
	public List<TipoContactoDTO> obtenerTipoContactos () {
		return this.tipocont.readAll();
	}
	
	public void agregarPaisProvLoc(PaisProvLocDTO nuevoPaisProvLoc)
	{
		this.paisProvLoc.insert(nuevoPaisProvLoc);
	}

	public void borrarPais(PaisProvLocDTO pais_a_eliminar) 
	{
		this.paisProvLoc.deletePais(pais_a_eliminar);
	}
	
	public void editarPais(PaisProvLocDTO pais_a_editar, String nuevo_pais)
	{
		this.paisProvLoc.updatePais(pais_a_editar, nuevo_pais);
	}
	
	public List<PaisProvLocDTO> obtenerPaisProvLoc()
	{
		return this.paisProvLoc.readAll();		
	}

	public void borrarProvincia(PaisProvLocDTO provincia_a_eliminar) 
	{
		this.paisProvLoc.deleteProvincia(provincia_a_eliminar);
	}
	
	public void editarProvincia(PaisProvLocDTO provincia_a_editar, String nueva_provincia)
	{
		this.paisProvLoc.updateProvincia(provincia_a_editar, nueva_provincia);
	}

	public void borrarLocalidad(PaisProvLocDTO localidad_a_eliminar) 
	{
		this.paisProvLoc.deleteLocalidad(localidad_a_eliminar);
	}
	
	public void editarLocalidad(PaisProvLocDTO localidad_a_editar, String nueva_localidad)
	{
		this.paisProvLoc.updateLocalidad(localidad_a_editar, nueva_localidad);
	}
	
}
