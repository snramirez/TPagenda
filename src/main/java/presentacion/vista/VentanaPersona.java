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
import dto.LocalidadDTO;
import dto.PaisDTO;
import dto.ProvinciaDTO;
import dto.TipoContactoDTO;

import javax.swing.JComboBox;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnAgregarPersona;
	private JButton btnEditarPais;
	private JButton btnEditarProv;
	private JButton btnEditarLoc;
	private JButton btnEditarTipo;
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
		setBounds(100, 100, 397, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 361, 471);		
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
		txtTelefono.setBounds(133, 49, 207, 20);
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

		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(251, 437, 89, 23);
		panel.add(btnAgregarPersona);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(10, 229, 46, 14);
		panel.add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(133, 226, 207, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setBounds(10, 267, 46, 14);
		panel.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(52, 264, 58, 20);
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
		panel.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setBounds(120, 267, 46, 14);
		panel.add(lblPiso);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(154, 264, 46, 20);
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

		panel.add(txtPiso);
		txtPiso.setColumns(10);
		
		JLabel lblDepto = new JLabel("Depto:");
		lblDepto.setBounds(210, 267, 46, 14);
		panel.add(lblDepto);
    
		txtDepto = new JTextField();
		txtDepto.setBounds(261, 267, 46, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setBounds(10, 194, 71, 14);
		panel.add(lblLocalidad);
		
		comboLocalidad = new JComboBox();
		comboLocalidad.setBounds(80, 190, 120, 20);
		panel.add(comboLocalidad);
		
		JLabel lblEmail = new JLabel("Email: *");
		lblEmail.setBounds(10, 89, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(133, 89, 207, 20);
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
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblCumpleaños = new JLabel("Cumpleaños:");
		lblCumpleaños.setBounds(10, 314, 79, 14);
		panel.add(lblCumpleaños);
    
		txtCumpleaños = new JTextField();
		txtCumpleaños.setText("AAAA/MM/DD");
		txtCumpleaños.setToolTipText("");
		txtCumpleaños.setBounds(113, 314, 86, 20);
		panel.add(txtCumpleaños);
		txtCumpleaños.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(10, 354, 46, 14);
		panel.add(lblTipo);
		
		comboTipo = new JComboBox<TipoContactoDTO>();
		comboTipo.setBounds(80, 351, 117, 20);
		panel.add(comboTipo);
		
		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setBounds(10, 133, 46, 14);
		panel.add(lblPais);
		comboPais = new JComboBox<>();
		comboPais.setBounds(80, 130, 120, 20);
		panel.add(comboPais);
		
		JLabel lblProvincia = new JLabel("Prov: ");
		lblProvincia.setBounds(10, 161, 46, 14);
		panel.add(lblProvincia);
		
		comboProvincia = new JComboBox();
		comboProvincia.setBounds(80, 160, 120, 20);
		panel.add(comboProvincia);
		
		btnEditarPais = new JButton("Editar");
		btnEditarPais.setBounds(227, 130, 89, 23);
		panel.add(btnEditarPais);
		
		btnEditarProv = new JButton("Editar");
		btnEditarProv.setBounds(227, 160, 89, 23);
		panel.add(btnEditarProv);
		
		btnEditarLoc = new JButton("Editar");
		btnEditarLoc.setBounds(227, 192, 89, 23);
		panel.add(btnEditarLoc);
		
		btnEditarTipo = new JButton("Editar");
		btnEditarTipo.setBounds(227, 350, 89, 23);
		panel.add(btnEditarTipo);		
		
		JLabel lblCodigoPostal = new JLabel("Cod. Postal:");
		lblCodigoPostal.setBounds(20, 426, 68, 14);
		panel.add(lblCodigoPostal);
		
		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setBounds(108, 423, 58, 20);
		panel.add(txtCodigoPostal);
		txtCodigoPostal.setColumns(10);
		
		JLabel lblLinkedin = new JLabel("Usuario LinkedIn: ");
		lblLinkedin.setBounds(10, 391, 89, 14);
		panel.add(lblLinkedin);
		
		txtLinkedin = new JTextField();
		txtLinkedin.setBounds(105, 388, 161, 20);
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
	
	public void llenarPais(List<PaisDTO> pais) 
	{	
		this.comboPais.removeAllItems();
		HashSet<String> set = new HashSet<>();
		for (PaisDTO p : pais)
		{
			if(!set.contains(p.getNombrePais()))
				this.comboPais.addItem(p.getNombrePais());
			set.add(p.getNombrePais());
		}
	}
	
	public void llenarProvincia(List<ProvinciaDTO> provincia) 
	{	
		this.comboProvincia.removeAllItems();
		HashSet<String> set = new HashSet<>();
		for (ProvinciaDTO p : provincia)
		{
			if(!set.contains(p.getNombreProvincia()))
				this.comboProvincia.addItem(p.getNombreProvincia());
			set.add(p.getNombreProvincia());
		}
	}
	
	public void llenarLocalidad(List<LocalidadDTO> localidad) 
	{	
		this.comboLocalidad.removeAllItems();
		HashSet<String> set = new HashSet<>();
		for (LocalidadDTO p : localidad)
		{
			if(!set.contains(p.getNombreLocalidad()))
				this.comboLocalidad.addItem(p.getNombreLocalidad());
			set.add(p.getNombreLocalidad());
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
	
	public JButton getBtnEditarPais() 
	{
		return btnEditarPais;
	}
	
	public JButton getBtnEditarProv() 
	{
		return btnEditarProv;
	}
	
	public JButton getBtnEditarLoc() 
	{
		return btnEditarLoc;
	}
	
	public JButton getBtnEditarTipo() 
	{
		return btnEditarTipo;
	}

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtAltura.setText(null);
		this.txtCalle.setText(null);
		this.txtCodigoPostal.setText(null);
		this.txtCumpleaños.setText("AAAA/MM/DD");
		this.txtDepto.setText(null);
		this.txtEmail.setText(null);
		this.txtLinkedin.setText(null);
		this.txtPiso.setText(null); 
		this.dispose();
	}
}

