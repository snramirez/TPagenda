package modelo;

import java.util.List;

import com.fasterxml.jackson.core.JsonToken;
import dto.DireccionDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DireccionDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;


public class Agenda 
{
	private PersonaDAO persona;
	private DireccionDAO dir;
	private TipoContactoDAO tipocont;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
		this.dir = metodo_persistencia.createDireccionDAO();
		this.tipocont = metodo_persistencia.createTipoContactoDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}

	public void agregarDireccion(DireccionDTO direccion) {
		this.dir.insert(direccion);
	}
	
	public List<DireccionDTO> obtenerDirecciones () {
		return this.dir.readAll();
	}

	public void agregarTipoContacto(TipoContactoDTO tipo) {
		this.tipocont.insert(tipo);
	}
	
	public List<TipoContactoDTO> obtenerTipoContactos () {
		return this.tipocont.readAll();
	}
}
