package presentacion.vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class VentanaAgregarTipo extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static VentanaAgregarTipo INSTANCE;
	private JTextField txtNombreTipo;
	private JButton btnAñadir;
	

	public static VentanaAgregarTipo getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaAgregarTipo(); 	
			return new VentanaAgregarTipo();
		}
		else
			return INSTANCE;
	}
	
	private VentanaAgregarTipo() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 240);
		getContentPane().setLayout(null);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese el tipo de contacto que desea añadir:");
		lblIngreseElNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngreseElNombre.setBounds(29, 27, 376, 35);
		getContentPane().add(lblIngreseElNombre);
		
		txtNombreTipo = new JTextField();
		txtNombreTipo.setBounds(39, 75, 334, 35);
		getContentPane().add(txtNombreTipo);
		txtNombreTipo.setColumns(10);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(151, 134, 105, 35);
		getContentPane().add(btnAñadir);
	}
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getNombreTipo() {
		return txtNombreTipo;
	}

	public JButton getBtnAñadir() {
		return btnAñadir;
	}
	
	public void cerrar()
	{
		this.txtNombreTipo.setText(null);
		this.dispose();
	}
	}