package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.DireccionDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = 
			"INSERT INTO personas(idPersona, nombre, telefono, Email, Fecha_nacimiento, IdDireccion, IdTipo) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = 
			"DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = 
			"SELECT idPersona, Nombre, Telefono, Email, Fecha_nacimiento, personas.IdDireccion, pais, provincia, localidad, calle, altura, piso, departamento, personas.IdTipo,  Nombre_tipo FROM personas LEFT JOIN direccion ON personas.iddireccion = direccion.iddireccion LEFT JOIN tipo_contacto ON personas.IdTipo = tipo_contacto.idtipo";
	private static final String update = 
			"UPDATE personas SET nombre = ? , telefono = ? , email = ? , Fecha_nacimiento = ? , IdDireccion = ?, IdTipo = ? WHERE idPersona = ?";
	
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getEmail());
			statement.setString(5, persona.getFecha_nacimiento());
			statement.setInt(6, persona.getDireccion().getIdDireccion());
			statement.setInt(7, persona.getTipoContacto().getIdTipoContacto());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersonaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	@Override
	public boolean update(PersonaDTO persona_a_editar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, persona_a_editar.getNombre());
			statement.setString(2, persona_a_editar.getTelefono());
			statement.setString(3, persona_a_editar.getEmail());
			statement.setString(4, persona_a_editar.getFecha_nacimiento());
			statement.setInt(5, persona_a_editar.getDireccion().getIdDireccion());
			statement.setInt(6, persona_a_editar.getTipoContacto().getIdTipoContacto());
			
			statement.setInt(7, persona_a_editar.getIdPersona());
			System.out.print(persona_a_editar.getDireccion().getIdDireccion());
			System.out.print(persona_a_editar.getTipoContacto().getIdTipoContacto());
			System.out.print(persona_a_editar.getIdPersona());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isUpdateExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isUpdateExitoso;
	}
	
	private PersonaDTO getPersonaDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		String email = resultSet.getString("Email");
		String fechaNacimiento = resultSet.getString("Fecha_nacimiento");
		DireccionDTO direccion = new DireccionDTO(
				resultSet.getInt("IdDireccion"), 
				resultSet.getString("pais"), 
				resultSet.getString("provincia"), 
				resultSet.getString("localidad"), 
				resultSet.getString("calle"), 
				resultSet.getString("altura"), 
				resultSet.getString("piso"), 
				resultSet.getString("departamento"));
		TipoContactoDTO tipoContacto = new TipoContactoDTO(
				resultSet.getInt("idtipo"),
				resultSet.getString("Nombre_tipo"));
		
		return new PersonaDTO(id, nombre, tel, email, fechaNacimiento, direccion, tipoContacto);
	}

	
}
