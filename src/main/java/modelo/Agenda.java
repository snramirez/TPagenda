package modelo;

import java.util.List;

import com.fasterxml.jackson.core.JsonToken;
import dto.DireccionDTO;
import dto.LocalidadDTO;
import dto.PaisDTO;
import dto.PersonaDTO;
import dto.ProvinciaDTO;
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
	
	public void agregarPais(PaisDTO nuevoPais)
	{
		this.paisProvLoc.insertPais(nuevoPais);
	}

	public void borrarPais(PaisDTO pais_a_eliminar) 
	{
		this.paisProvLoc.deletePais(pais_a_eliminar);
	}
	
	public void editarPais(PaisDTO pais_a_editar)
	{
		this.paisProvLoc.updatePais(pais_a_editar);
	}
	
	public List<PaisDTO> obtenerPais()
	{
		return this.paisProvLoc.readAllPais();		
	}
	
	public void agregarProvincia(ProvinciaDTO nuevaProvincia)
	{
		this.paisProvLoc.insertProvincia(nuevaProvincia);
	}

	public void borrarProvincia(ProvinciaDTO provincia_a_eliminar) 
	{
		this.paisProvLoc.deleteProvincia(provincia_a_eliminar);
	}
	
	public void editarProvincia(ProvinciaDTO provincia_a_editar)
	{
		this.paisProvLoc.updateProvincia(provincia_a_editar);
	}
	
	public List<ProvinciaDTO> obtenerProvincia()
	{
		return this.paisProvLoc.readAllProvincia();		
	}
	
	public void agregarLocalidad(LocalidadDTO nuevaLocalidad)
	{
		this.paisProvLoc.insertLocalidad(nuevaLocalidad);
	}

	public void borrarLocalidad(LocalidadDTO localidad_a_eliminar) 
	{
		this.paisProvLoc.deleteLocalidad(localidad_a_eliminar);
	}
	
	public void editarLocalidad(LocalidadDTO localidad_a_editar)
	{
		this.paisProvLoc.updateLocalidad(localidad_a_editar);
	}
	
	public List<LocalidadDTO> obtenerLocalidad()
	{
		return this.paisProvLoc.readAllLocalidad();		
	}
}
