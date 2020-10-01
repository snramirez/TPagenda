package presentacion.vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class VentanaEditarLocalidad extends JFrame{
	private static final long serialVersionUID = 1L;
	private static VentanaEditarLocalidad INSTANCE;
	private JTextField txtNombreLocalidad;
	private JButton btnAñadir;
	

	public static VentanaEditarLocalidad getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaEditarLocalidad(); 	
			return new VentanaEditarLocalidad();
		}
		else
			return INSTANCE;
	}
	
	private VentanaEditarLocalidad() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 240);
		getContentPane().setLayout(null);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese el nombre de la localidad que desea editar:");
		lblIngreseElNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngreseElNombre.setBounds(29, 27, 376, 35);
		getContentPane().add(lblIngreseElNombre);
		
		txtNombreLocalidad = new JTextField();
		txtNombreLocalidad.setBounds(39, 75, 334, 35);
		getContentPane().add(txtNombreLocalidad);
		txtNombreLocalidad.setColumns(10);
		
		btnAñadir = new JButton("Editar");
		btnAñadir.setBounds(151, 134, 105, 35);
		getContentPane().add(btnAñadir);
	}
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getNombreLocalidad() {
		return txtNombreLocalidad;
	}

	public JButton getBtnEditar() {
		return btnAñadir;
	}
	
	public void cerrar()
	{
		this.txtNombreLocalidad.setText(null);
		this.dispose();
	}
}