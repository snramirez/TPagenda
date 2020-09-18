package presentacion.vista;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.DireccionDTO;
import dto.TipoContactoDTO;

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
	private JComboBox<TipoContactoDTO> comboTipo;
	private JComboBox<String> comboProvincia;
	private JComboBox<String> comboPais;
	private JComboBox<String> comboLocalidad;
	
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
		setBounds(100, 100, 397, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 361, 334);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido: *");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono: *");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 207, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(79, 49, 218, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(208, 300, 89, 23);
		panel.add(btnAgregarPersona);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(10, 203, 46, 14);
		panel.add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(49, 200, 152, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setBounds(10, 241, 46, 14);
		panel.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(52, 238, 58, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setBounds(120, 241, 46, 14);
		panel.add(lblPiso);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(153, 238, 46, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);
		
		JLabel lblDepto = new JLabel("Depto:");
		lblDepto.setBounds(213, 241, 46, 14);
		panel.add(lblDepto);
		
		txtDepto = new JTextField();
		txtDepto.setBounds(251, 238, 46, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setBounds(10, 168, 71, 14);
		panel.add(lblLocalidad);
		
		comboLocalidad = new JComboBox();
		comboLocalidad.setBounds(79, 165, 134, 20);
		panel.add(comboLocalidad);
		
		JLabel lblEmail = new JLabel("Email: *");
		lblEmail.setBounds(10, 89, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(66, 88, 177, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblCumpleaños = new JLabel("Cumpleaños:");
		lblCumpleaños.setBounds(10, 272, 79, 14);
		panel.add(lblCumpleaños);
		
		txtCumpleaños = new JTextField();
		txtCumpleaños.setText("DD/MM");
		txtCumpleaños.setToolTipText("");
		txtCumpleaños.setBounds(94, 269, 86, 20);
		panel.add(txtCumpleaños);
		txtCumpleaños.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(195, 272, 46, 14);
		panel.add(lblTipo);
		
		comboTipo = new JComboBox<TipoContactoDTO>();
		comboTipo.setBounds(234, 269, 117, 20);
		panel.add(comboTipo);
		
		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setBounds(10, 133, 46, 14);
		panel.add(lblPais);
		
		comboPais = new JComboBox<>();
		comboPais.setBounds(49, 130, 117, 20);
		panel.add(comboPais);
		
		JLabel lblProvincia = new JLabel("Prov: ");
		lblProvincia.setBounds(180, 133, 46, 14);
		panel.add(lblProvincia);
		
		comboProvincia = new JComboBox();
		comboProvincia.setBounds(219, 130, 121, 20);
		panel.add(comboProvincia);
		
		this.setVisible(false);
	}
	
	public TipoContactoDTO getTipo() 
	{
		return (TipoContactoDTO) comboTipo.getSelectedItem();
	}
	
	public void llenarTipos(List<TipoContactoDTO> Tipos) 
	{	
		this.comboTipo.removeAllItems();
		for (TipoContactoDTO p : Tipos)
		{
			this.comboTipo.addItem(p);
		}
	}
	
	public void llenarPais(List<DireccionDTO> Direcciones) 
	{	
		this.comboPais.removeAllItems();
		for (DireccionDTO p : Direcciones)
		{
			this.comboPais.addItem(p.getPais());
		}
	}
	
	public void llenarProvincia(List<DireccionDTO> Direcciones) 
	{	
		this.comboProvincia.removeAllItems();
		for (DireccionDTO p : Direcciones)
		{
			this.comboProvincia.addItem(p.getProvincia());
		}
	}
	
	public void llenarLocalidad(List<DireccionDTO> Direcciones) 
	{	
		this.comboLocalidad.removeAllItems();
		for (DireccionDTO p : Direcciones)
		{
			this.comboLocalidad.addItem(p.getLocalidad());
		}
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() {return txtNombre;}
	public JTextField getTxtTelefono() {return txtTelefono;}
	public JTextField getTxtEmail() {return txtEmail;}
	public JTextField getTxtCumpleaños(){return txtCumpleaños; }
	public JTextField getTxtCalle(){return txtCalle;}
	public JTextField getTxtPiso(){return txtPiso;}
	public JTextField getTxtDepto(){return txtDepto;}
	public JTextField getTxtAltura(){return txtAltura;}
	public JComboBox getTipoContacto(){return comboTipo;}
	public JComboBox getLocalidad(){return comboLocalidad;}
	public JComboBox getPais(){return comboPais;}
	public JComboBox getProvincia(){return comboProvincia;}

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

