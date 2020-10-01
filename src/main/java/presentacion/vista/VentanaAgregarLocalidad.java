package presentacion.vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class VentanaAgregarLocalidad extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static VentanaAgregarLocalidad INSTANCE;
	private JTextField txtNombreLocalidad;
	private JButton btnAñadir;
	

	public static VentanaAgregarLocalidad getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaAgregarLocalidad(); 	
			return new VentanaAgregarLocalidad();
		}
		else
			return INSTANCE;
	}
	
	private VentanaAgregarLocalidad() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 240);
		getContentPane().setLayout(null);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese el nombre de la localidad que desea añadir:");
		lblIngreseElNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngreseElNombre.setBounds(29, 27, 376, 35);
		getContentPane().add(lblIngreseElNombre);
		
		txtNombreLocalidad = new JTextField();
		txtNombreLocalidad.setBounds(39, 75, 334, 35);
		getContentPane().add(txtNombreLocalidad);
		txtNombreLocalidad.setColumns(10);
		
		btnAñadir = new JButton("Añadir");
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

	public JButton getBtnAñadir() {
		return btnAñadir;
	}
	
	public void cerrar()
	{
		this.txtNombreLocalidad.setText(null);
		this.dispose();
	}
	}