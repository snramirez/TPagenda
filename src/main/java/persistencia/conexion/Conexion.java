package persistencia.conexion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.log4j.Logger;

public class Conexion
{
	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);
	private boolean connected = false;

	private Conexion(String user, String password)
	{
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver"); // quitar si no es necesario
			Class.forName("org.mariadb.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/grupo7?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",user,password);
			this.connection.setAutoCommit(false);
			log.info("Conexión exitosa");
			connected = true;
			ejecutarScript();
		}
		catch(Exception e)
		{
			log.error("Conexión fallida", e);
		}
	}
	private void ejecutarScript() throws IOException {
		Connection conn = this.connection;
		ScriptRunner runner = new ScriptRunner(conn);
		InputStreamReader reader = null;

		try {
			reader = new InputStreamReader(new FileInputStream("sql/scriptAgenda.sql"), "UTF-8");
			runner.runScript(reader);
			reader.close();
		} finally {

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				reader = null;
			}
		}
	}

	public static Conexion getConexion()
	{
		return instancia;
	}

	public static boolean verificarCredenciales(String username, String password){
		instancia = new Conexion(username,password);
		return instancia.connected;
	}

	public Connection getSQLConexion()
	{
		return this.connection;
	}

	public void cerrarConexion()
	{
		try
		{
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e)
		{
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
}
