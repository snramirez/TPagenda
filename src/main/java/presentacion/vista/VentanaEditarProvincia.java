package presentacion.vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class VentanaEditarProvincia extends JFrame{
	private static final long serialVersionUID = 1L;
	private static VentanaEditarProvincia INSTANCE;
	private JTextField txtNombreProvincia;
	private JButton btnAñadir;
	

	public static VentanaEditarProvincia getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaEditarProvincia(); 	
			return new VentanaEditarProvincia();
		}
		else
			return INSTANCE;
	}
	
	private VentanaEditarProvincia() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 240);
		getContentPane().setLayout(null);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese el nombre de la provincia que desea editar:");
		lblIngreseElNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngreseElNombre.setBounds(29, 27, 376, 35);
		getContentPane().add(lblIngreseElNombre);
		
		txtNombreProvincia = new JTextField();
		txtNombreProvincia.setBounds(39, 75, 334, 35);
		getContentPane().add(txtNombreProvincia);
		txtNombreProvincia.setColumns(10);
		
		btnAñadir = new JButton("Editar");
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

	public JButton getBtnEditar() {
		return btnAñadir;
	}
	
	public void cerrar()
	{
		this.txtNombreProvincia.setText(null);
		this.dispose();
	}
}