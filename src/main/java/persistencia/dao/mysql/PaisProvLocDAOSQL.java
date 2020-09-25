package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.LocalidadDTO;
import dto.PaisDTO;
import dto.ProvinciaDTO;
import dto.TipoContactoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PaisProvLocDAO;

public class PaisProvLocDAOSQL implements PaisProvLocDAO{

	private static final String insertPais = "INSERT INTO pais(idpais, nombre_pais) VALUES(?, ?)";
	private static final String insertProvincia = "INSERT INTO provincia(idprovincia, nombre_provincia) VALUES(?, ?)";
	private static final String insertLocalidad = "INSERT INTO localidad(idlocalidad, nombre_localidad) VALUES(?, ?)";
	
	private static final String deletePais = "DELETE FROM pais WHERE idpais = ?";
	private static final String deleteProvincia = "DELETE FROM provincia WHERE idprovincia = ?";
	private static final String deleteLocalidad = "DELETE FROM localidad WHERE idlocalidad = ?";
	
	private static final String updatePais = "UPDATE pais SET nombre_pais = ? WHERE idpais = ?";
	private static final String updateProvincia = "UPDATE provincia SET nombre_provincia = ? WHERE idprovincia = ?";
	private static final String updateLocalidad = "UPDATE localidad SET nombre_localidad = ? WHERE idlocalidad = ?";
	
	private static final String readallPais = "SELECT * from pais;";
	private static final String readallProvincia = "SELECT * from provincia;";
	private static final String readallLocalidad = "SELECT * from localidad;";
	
	@Override
	public boolean insertPais(PaisDTO pais) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(insertPais);
			statement.setInt(1, pais.getIdPais());
			statement.setString(2, pais.getNombrePais());
		
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

	@Override
	public boolean insertProvincia(ProvinciaDTO provincia) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(insertProvincia);
			statement.setInt(1, provincia.getIdProvincia());
			statement.setString(2, provincia.getNombreProvincia());
		
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

	@Override
	public boolean insertLocalidad(LocalidadDTO localidad) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(insertLocalidad);
			statement.setInt(1, localidad.getIdLocalidad());
			statement.setString(2, localidad.getNombreLocalidad());
		
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

	@Override
	public boolean deletePais(PaisDTO pais_a_borrar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(deletePais);
			statement.setString(1, Integer.toString(pais_a_borrar.getIdPais()));
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

	@Override
	public boolean deleteProvincia(ProvinciaDTO provincia_a_borrar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(deleteProvincia);
			statement.setString(1, Integer.toString(provincia_a_borrar.getIdProvincia()));
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

	@Override
	public boolean deleteLocalidad(LocalidadDTO localidad_a_borrar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(deleteLocalidad);
			statement.setString(1, Integer.toString(localidad_a_borrar.getIdLocalidad()));
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

	@Override
	public boolean updatePais(PaisDTO pais_a_editar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(updatePais);
			statement.setString(1, pais_a_editar.getNombrePais());
			statement.setInt(2, pais_a_editar.getIdPais());
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

	@Override
	public boolean updateProvincia(ProvinciaDTO provincia_a_editar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(updateProvincia);
			statement.setString(1, provincia_a_editar.getNombreProvincia());
			statement.setInt(2, provincia_a_editar.getIdProvincia());
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

	@Override
	public boolean updateLocalidad(LocalidadDTO localidad_a_editar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(updateProvincia);
			statement.setString(1, localidad_a_editar.getNombreLocalidad());
			statement.setInt(2, localidad_a_editar.getIdLocalidad());
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

	@Override
	public List<PaisDTO> readAllPais() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PaisDTO> pais = new ArrayList<PaisDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readallPais);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				pais.add(getPaisDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return pais;
	}

	@Override
	public List<ProvinciaDTO> readAllProvincia() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<ProvinciaDTO> provincia = new ArrayList<ProvinciaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readallProvincia);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				provincia.add(getProvinciaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return provincia;
	}

	@Override
	public List<LocalidadDTO> readAllLocalidad() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<LocalidadDTO> localidad = new ArrayList<LocalidadDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readallLocalidad);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				localidad.add(getLocalidadDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return localidad;
	}
	
	private PaisDTO getPaisDTO(ResultSet resultSet) throws SQLException 
	{
		int id = resultSet.getInt("idpais");
		String nombre_pais = resultSet.getString("nombre_pais");
		
		return new PaisDTO(id, nombre_pais);
	}
	
	private ProvinciaDTO getProvinciaDTO(ResultSet resultSet) throws SQLException 
	{
		int id = resultSet.getInt("idprovincia");
		String nombre_provincia = resultSet.getString("nombre_provincia");
		
		return new ProvinciaDTO(id, nombre_provincia);
	}
	
	private LocalidadDTO getLocalidadDTO(ResultSet resultSet) throws SQLException 
	{
		int id = resultSet.getInt("idlocalidad");
		String nombre_localidad = resultSet.getString("nombre_localidad");
		
		return new LocalidadDTO(id, nombre_localidad);
	}

}
