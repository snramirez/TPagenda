package presentacion.vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class VentanaAgregarPais extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static VentanaAgregarPais INSTANCE;
	private JTextField txtNombrePais;
	private JButton btnAñadir;
	

	public static VentanaAgregarPais getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaAgregarPais(); 	
			return new VentanaAgregarPais();
		}
		else
			return INSTANCE;
	}
	
	private VentanaAgregarPais() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 240);
		getContentPane().setLayout(null);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese el nombre del pais que desea añadir:");
		lblIngreseElNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngreseElNombre.setBounds(29, 27, 376, 35);
		getContentPane().add(lblIngreseElNombre);
		
		txtNombrePais = new JTextField();
		txtNombrePais.setBounds(39, 75, 334, 35);
		getContentPane().add(txtNombrePais);
		txtNombrePais.setColumns(10);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(151, 134, 105, 35);
		getContentPane().add(btnAñadir);
	}
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getNombrePais() {
		return txtNombrePais;
	}

	public JButton getBtnAñadir() {
		return btnAñadir;
	}
	
	public void cerrar()
	{
		this.txtNombrePais.setText(null);
		this.dispose();
	}
	}
