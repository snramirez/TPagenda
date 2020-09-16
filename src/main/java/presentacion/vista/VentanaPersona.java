package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnAgregarPersona;
	private static VentanaPersona INSTANCE;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDepto;
	private JTextField txtEmail;
	private JTextField txtCumpleaños;
	
	public static VentanaPersona getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersona(); 	
			return new VentanaPersona();
		}
		else
			return INSTANCE;
	}

	private VentanaPersona() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 334);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido: *");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono: *");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(79, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(208, 300, 89, 23);
		panel.add(btnAgregarPersona);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(10, 128, 46, 14);
		panel.add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(49, 125, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setBounds(10, 166, 46, 14);
		panel.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(52, 163, 58, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setBounds(120, 166, 46, 14);
		panel.add(lblPiso);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(153, 163, 46, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);
		
		JLabel lblDepto = new JLabel("Depto:");
		lblDepto.setBounds(213, 166, 46, 14);
		panel.add(lblDepto);
		
		txtDepto = new JTextField();
		txtDepto.setBounds(251, 163, 46, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setBounds(10, 200, 71, 14);
		panel.add(lblLocalidad);
		
		JComboBox comboLocalidad = new JComboBox();
		comboLocalidad.setBounds(79, 197, 134, 20);
		panel.add(comboLocalidad);
		
		JLabel lblEmail = new JLabel("Email: *");
		lblEmail.setBounds(10, 89, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(66, 88, 177, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblCumpleaños = new JLabel("Cumpleaños:");
		lblCumpleaños.setBounds(7, 238, 79, 14);
		panel.add(lblCumpleaños);
		
		txtCumpleaños = new JTextField();
		txtCumpleaños.setText("DD/MM");
		txtCumpleaños.setToolTipText("");
		txtCumpleaños.setBounds(91, 235, 86, 20);
		panel.add(txtCumpleaños);
		txtCumpleaños.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(10, 279, 46, 14);
		panel.add(lblTipo);
		
		JComboBox comboTipo = new JComboBox();
		comboTipo.setBounds(49, 276, 117, 20);
		panel.add(comboTipo);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.dispose();
	}
}

