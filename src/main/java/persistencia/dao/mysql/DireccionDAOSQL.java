package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DireccionDTO;
import dto.PersonaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.DireccionDAO;

public class DireccionDAOSQL implements DireccionDAO {
	
	private static final String insert = 
			"INSERT INTO direccion(iddireccion, pais, provincia, localidad, calle, altura, piso, departamento) VALUES (?,?,?,?,?,?,?,?)";
	private static final String delete = 
			"DELETE FROM direccion WHERE iddireccion = ?";
	private static final String readall = 
			"SELECT * from direccion;";
	private static final String update = 
			"UPDATE direccion SET pais = ?, provincia = ?, localidad = ?, calle = ?, altura = ?, piso = ?, departamento = ? WHERE iddireccion = ?";
	private static final String lastInsert = 
			"SELECT * FROM direccion WHERE iddireccion = (SELECT MAX(iddireccion) FROM direccion)";

	@Override
	public boolean insert(DireccionDTO direccion) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, direccion.getIdDireccion());
			statement.setString(2, direccion.getPais());
			statement.setString(3, direccion.getProvincia());
			statement.setString(4, direccion.getLocalidad());
			statement.setString(5, direccion.getCalle());
			statement.setString(6, direccion.getAltura());
			statement.setString(7, direccion.getPiso());
			statement.setString(8, direccion.getDepartamento());
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
	public boolean delete(DireccionDTO direccion_a_borrar) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(direccion_a_borrar.getIdDireccion()));
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
	public boolean update(DireccionDTO direccion_a_editar) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, direccion_a_editar.getPais());
			statement.setString(2, direccion_a_editar.getProvincia());
			statement.setString(3, direccion_a_editar.getLocalidad());
			statement.setString(4, direccion_a_editar.getCalle());
			statement.setString(5, direccion_a_editar.getAltura());
			statement.setString(6, direccion_a_editar.getPiso());
			statement.setString(7, direccion_a_editar.getDepartamento());
			
			statement.setInt(8, direccion_a_editar.getIdDireccion());
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
	public List<DireccionDTO> readAll() 
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<DireccionDTO> direccion = new ArrayList<DireccionDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				direccion.add(getDireccionDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return direccion;
	}
	
	public DireccionDTO lastInsert()
	{
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		DireccionDTO direccion = null;
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(lastInsert);
			resultSet = statement.executeQuery();
			if(resultSet.next())
			{
				direccion = getDireccionDTO(resultSet);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return direccion;
	}

	private DireccionDTO getDireccionDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("IdDireccion");
		String pais = resultSet.getString("pais"); 
		String provincia = resultSet.getString("provincia"); 
		String localidad = resultSet.getString("localidad"); 
		String calle = resultSet.getString("calle"); 
		String altura = resultSet.getString("altura"); 
		String piso = resultSet.getString("piso"); 
		String departamento = resultSet.getString("departamento");
		
		return new DireccionDTO(id, pais, provincia, localidad, calle, altura, piso, departamento);
	}

}
