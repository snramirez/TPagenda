package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DireccionDTO;
import dto.TipoContactoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.TipoContactoDAO;

public class TipoContactoDAOSQL implements TipoContactoDAO {
	
	private static final String insert = 
			"INSERT INTO tipo_contacto(idtipo, Nombre_tipo) VALUES (?,?)";
	private static final String delete = 
			"DELETE FROM tipo_contacto WHERE idtipo = ?";
	private static final String readall = 
			"SELECT * from tipo_contacto;";
	private static final String update = 
			"UPDATE tipo_contacto SET Nombre_tipo = ? WHERE idtipo = ?";


	@Override
	public boolean insert(TipoContactoDTO tipoContacto) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, tipoContacto.getIdTipoContacto());
			statement.setString(2, tipoContacto.getNombreTipoContacto());
		
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
	public boolean delete(TipoContactoDTO tipoContactoEliminar) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(tipoContactoEliminar.getIdTipoContacto()));
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
	public boolean update(TipoContactoDTO tipoContactoEditar) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, tipoContactoEditar.getNombreTipoContacto());
			statement.setInt(2, tipoContactoEditar.getIdTipoContacto());
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
	public List<TipoContactoDTO> readAll() 
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<TipoContactoDTO> tipoContacto = new ArrayList<TipoContactoDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				tipoContacto.add(getTipoContactoDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return tipoContacto;
	}

	private TipoContactoDTO getTipoContactoDTO(ResultSet resultSet) throws SQLException 
	{
		int id = resultSet.getInt("idtipo");
		String nombre_tipo = resultSet.getString("Nombre_tipo");
		
		return new TipoContactoDTO(id, nombre_tipo);
	}

}
