package presentacion.vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class VentanaAgregarProvincia extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static VentanaAgregarProvincia INSTANCE;
	private JTextField txtNombreProvincia;
	private JButton btnAñadir;
	

	public static VentanaAgregarProvincia getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaAgregarProvincia(); 	
			return new VentanaAgregarProvincia();
		}
		else
			return INSTANCE;
	}
	
	private VentanaAgregarProvincia() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 240);
		getContentPane().setLayout(null);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese el nombre de la provincia que desea añadir:");
		lblIngreseElNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngreseElNombre.setBounds(29, 27, 376, 35);
		getContentPane().add(lblIngreseElNombre);
		
		txtNombreProvincia = new JTextField();
		txtNombreProvincia.setBounds(39, 75, 334, 35);
		getContentPane().add(txtNombreProvincia);
		txtNombreProvincia.setColumns(10);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(151, 134, 105, 35);
		getContentPane().add(btnAñadir);
	}
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getNombreProvincia() {
		return txtNombreProvincia;
	}

	public JButton getBtnAñadir() {
		return btnAñadir;
	}
	
	public void cerrar()
	{
		this.txtNombreProvincia.setText(null);
		this.dispose();
	}
	}
