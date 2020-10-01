package presentacion.vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class VentanaEditarTipo extends JFrame{
	private static final long serialVersionUID = 1L;
	private static VentanaEditarTipo INSTANCE;
	private JTextField txtNombreTipo;
	private JButton btnAñadir;
	

	public static VentanaEditarTipo getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaEditarTipo(); 	
			return new VentanaEditarTipo();
		}
		else
			return INSTANCE;
	}
	
	private VentanaEditarTipo() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 240);
		getContentPane().setLayout(null);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese el tipo de contacto que desea editar:");
		lblIngreseElNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngreseElNombre.setBounds(29, 27, 376, 35);
		getContentPane().add(lblIngreseElNombre);
		
		txtNombreTipo = new JTextField();
		txtNombreTipo.setBounds(39, 75, 334, 35);
		getContentPane().add(txtNombreTipo);
		txtNombreTipo.setColumns(10);
		
		btnAñadir = new JButton("Editar");
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

	public JButton getBtnEditar() {
		return btnAñadir;
	}
	
	public void cerrar()
	{
		this.txtNombreTipo.setText(null);
		this.dispose();
	}
}