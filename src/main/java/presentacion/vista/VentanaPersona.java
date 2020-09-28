package presentacion.vista;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField txtCodigoPostal;
	private JTextField txtLinkedin;
	
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
		setBounds(100, 100, 397, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 361, 368);
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
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent key) {
				char letra = key.getKeyChar();
				//checkea que no sea un numero
				if(letra < '0' || letra > '9') {
					//checkea que no sea borrar o escape
					if(!((int)key.getKeyChar() == 27 || (int)key.getKeyChar() == 8)) {
						key.consume();
						JOptionPane.showMessageDialog(rootPane,"Solo numeros");
					}
				}
			}
		});
		txtTelefono.setBounds(79, 49, 218, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(208, 334, 89, 23);
		panel.add(btnAgregarPersona);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(10, 237, 46, 14);
		panel.add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(49, 234, 152, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setBounds(10, 275, 46, 14);
		panel.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent key) {
				char letra = key.getKeyChar();
				//checkea que no sea un numero
				if(letra < '0' || letra > '9') {
					//checkea que no sea borrar o escape
					if(!((int)key.getKeyChar() == 27 || (int)key.getKeyChar() == 8)) {
						key.consume();
						JOptionPane.showMessageDialog(rootPane,"Solo numeros");
					}
				}
			}
		});
		txtAltura.setBounds(52, 272, 58, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setBounds(120, 275, 46, 14);
		panel.add(lblPiso);
		
		txtPiso = new JTextField();
		txtPiso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent key) {
				char letra = key.getKeyChar();
				//checkea que no sea un numero
				if(letra < '0' || letra > '9') {
					//checkea que no sea borrar o escape
					if(!((int)key.getKeyChar() == 27 || (int)key.getKeyChar() == 8)) {
						key.consume();
						JOptionPane.showMessageDialog(rootPane,"Solo numeros");
					}
				}
			}
		});
		txtPiso.setBounds(153, 272, 46, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);
		
		JLabel lblDepto = new JLabel("Depto:");
		lblDepto.setBounds(213, 275, 46, 14);
		panel.add(lblDepto);
		
		txtDepto = new JTextField();
		txtDepto.setBounds(251, 272, 46, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setBounds(10, 202, 71, 14);
		panel.add(lblLocalidad);
		
		comboLocalidad = new JComboBox();
		comboLocalidad.setBounds(79, 199, 134, 20);
		panel.add(comboLocalidad);
		
		JLabel lblEmail = new JLabel("Email: *");
		lblEmail.setBounds(10, 89, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent event) {
				String email = txtEmail.getText().toString();
				Pattern patron = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				Matcher mat = patron.matcher(email);
				if(!mat.find()) {
					JOptionPane.showMessageDialog(rootPane, "Formato de email invalido ej 'nombre@compania.com'");
				}
			}
		});
		txtEmail.setBounds(66, 88, 177, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblCumpleaños = new JLabel("Cumpleaños:");
		lblCumpleaños.setBounds(10, 306, 79, 14);
		panel.add(lblCumpleaños);
		
		txtCumpleaños = new JTextField();
		txtCumpleaños.setText("AAAA/MM/DD");
		txtCumpleaños.setToolTipText("");
		txtCumpleaños.setBounds(94, 303, 86, 20);
		panel.add(txtCumpleaños);
		txtCumpleaños.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(195, 306, 46, 14);
		panel.add(lblTipo);
		
		comboTipo = new JComboBox<TipoContactoDTO>();
		comboTipo.setBounds(234, 303, 117, 20);
		panel.add(comboTipo);
		
		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setBounds(10, 167, 46, 14);
		panel.add(lblPais);
		
		comboPais = new JComboBox<>();
		comboPais.setBounds(49, 164, 117, 20);
		panel.add(comboPais);
		
		JLabel lblProvincia = new JLabel("Prov: ");
		lblProvincia.setBounds(180, 167, 46, 14);
		panel.add(lblProvincia);
		
		comboProvincia = new JComboBox();
		comboProvincia.setBounds(219, 164, 121, 20);
		panel.add(comboProvincia);
		
		JLabel lblCodigoPostal = new JLabel("Cod. Postal:");
		lblCodigoPostal.setBounds(229, 202, 68, 14);
		panel.add(lblCodigoPostal);
		
		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setBounds(293, 199, 58, 20);
		panel.add(txtCodigoPostal);
		txtCodigoPostal.setColumns(10);
		
		JLabel lblLinkedin = new JLabel("Usuario LinkedIn: ");
		lblLinkedin.setBounds(10, 127, 89, 14);
		panel.add(lblLinkedin);
		
		txtLinkedin = new JTextField();
		txtLinkedin.setBounds(113, 124, 161, 20);
		panel.add(txtLinkedin);
		txtLinkedin.setColumns(10);
		
		this.setVisible(false);
	}
	
	public TipoContactoDTO getTipo() 
	{
		return (TipoContactoDTO) comboTipo.getSelectedItem();
	}
	
	public void llenarTipos(List<TipoContactoDTO> Tipos) 
	{	
		this.comboTipo.removeAllItems();
		HashSet<String> set = new HashSet<>();
		for (TipoContactoDTO p : Tipos)
		{
			if(!set.contains(p.getNombreTipoContacto()))
				this.comboTipo.addItem(p);
			set.add(p.getNombreTipoContacto());
		}
	}
	
	public void llenarPais(List<DireccionDTO> Direcciones) 
	{	
		this.comboPais.removeAllItems();
		HashSet<String> set = new HashSet<>();
		for (DireccionDTO p : Direcciones)
		{
			if(!set.contains(p.getPais()))
				this.comboPais.addItem(p.getPais());
			set.add(p.getPais());
		}
	}
	
	public void llenarProvincia(List<DireccionDTO> Direcciones) 
	{	
		this.comboProvincia.removeAllItems();
		HashSet<String> set = new HashSet<>();
		for (DireccionDTO p : Direcciones)
		{
			if(!set.contains(p.getProvincia()))
				this.comboProvincia.addItem(p.getProvincia());
			set.add(p.getProvincia());
		}
	}
	
	public void llenarLocalidad(List<DireccionDTO> Direcciones) 
	{	
		this.comboLocalidad.removeAllItems();
		HashSet<String> set = new HashSet<>();
		for (DireccionDTO p : Direcciones)
		{
			if(!set.contains(p.getLocalidad()))
				this.comboLocalidad.addItem(p.getLocalidad());
			set.add(p.getLocalidad());
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
	public JTextField getLinkedin(){return txtLinkedin;}
	public JTextField getCodigoPostal(){return txtCodigoPostal;}
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

