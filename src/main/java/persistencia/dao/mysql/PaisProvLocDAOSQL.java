package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PaisProvLocDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PaisProvLocDAO;

public class PaisProvLocDAOSQL implements PaisProvLocDAO{

	private static final String insert = "INSERT INTO paisprovloc(idpaisprovloc, nombre_pais, nombre_provincia, nombre_localidad) VALUES(?, ?, ?, ?)";
	
	private static final String deletePais = "DELETE FROM paisprovloc WHERE nombre_pais = ?";
	private static final String deleteProvincia = "DELETE FROM paisprovloc WHERE nombre_pais = ? AND nombre_provincia = ?";
	private static final String deleteLocalidad = "DELETE FROM paisprovloc WHERE nombre_pais = ? AND nombre_provincia = ? AND nombre_localidad = ?";
	
	private static final String updatePais = "UPDATE paisprovloc SET nombre_pais = ? WHERE nombre_pais = ?";
	private static final String updateProvincia = "UPDATE paisprovloc SET nombre_provincia = ? WHERE nombre_pais = ? AND nombre_provincia = ?";
	private static final String updateLocalidad = "UPDATE paisprovloc SET nombre_localidad = ? WHERE nombre_pais = ? AND nombre_provincia = ? AND nombre_localidad = ?";
	
	private static final String readall = "SELECT * from paisprovloc;";
	
	@Override
	public boolean insert(PaisProvLocDTO pais) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, pais.getIdPaisProvLoc());
			statement.setString(2, pais.getPais());
			statement.setString(3, pais.getProvincia());
			statement.setString(4, pais.getLocalidad());
		
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
	public boolean deletePais(PaisProvLocDTO pais_a_borrar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(deletePais);
			statement.setString(1, pais_a_borrar.getPais());
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
	public boolean deleteProvincia(PaisProvLocDTO provincia_a_borrar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(deleteProvincia);
			statement.setString(1, provincia_a_borrar.getPais());
			statement.setString(2, provincia_a_borrar.getProvincia());
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
	public boolean deleteLocalidad(PaisProvLocDTO localidad_a_borrar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(deleteLocalidad);
			statement.setString(1, localidad_a_borrar.getPais());
			statement.setString(2, localidad_a_borrar.getProvincia());
			statement.setString(3, localidad_a_borrar.getLocalidad());
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
	public boolean updatePais(PaisProvLocDTO pais_a_editar, String nuevo_pais) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(updatePais);
			statement.setString(1, nuevo_pais);
			statement.setString(2, pais_a_editar.getPais());
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
	public boolean updateProvincia(PaisProvLocDTO provincia_a_editar, String nueva_provincia) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(updateProvincia);
			statement.setString(1, nueva_provincia);
			statement.setString(2, provincia_a_editar.getPais());
			statement.setString(3, provincia_a_editar.getProvincia());
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
	public boolean updateLocalidad(PaisProvLocDTO localidad_a_editar, String nueva_localidad) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(updateLocalidad);
			statement.setString(1, nueva_localidad);
			statement.setString(2, localidad_a_editar.getPais());
			statement.setString(3, localidad_a_editar.getProvincia());
			statement.setString(4, localidad_a_editar.getLocalidad());
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
	public List<PaisProvLocDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PaisProvLocDTO> pais = new ArrayList<PaisProvLocDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				pais.add(getPaisProvLocDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return pais;
	}
	
	private PaisProvLocDTO getPaisProvLocDTO(ResultSet resultSet) throws SQLException 
	{
		int id = resultSet.getInt("idpaisprovloc");
		String nombre_pais = resultSet.getString("nombre_pais");
		String nombre_provincia = resultSet.getString("nombre_provincia");
		String nombre_localidad = resultSet.getString("nombre_localidad");
		
		return new PaisProvLocDTO(id, nombre_pais, nombre_provincia, nombre_localidad);
	}
	

}
