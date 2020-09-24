package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.conexion.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JButton btnIngresar;
	private static Login INSTANCE;

	/**
	 * Create the frame.
	 */
	public Login() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Conexion a la base de datos");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setBounds(123, 11, 193, 37);
		contentPane.add(lblTitulo);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(89, 96, 63, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(89, 161, 69, 14);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(162, 94, 155, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 159, 155, 20);
		contentPane.add(passwordField);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(162, 216, 89, 23);
		contentPane.add(btnIngresar);
	}
	
	public static Login getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new Login(); 	
			return new Login();
		}
		else
			return INSTANCE;
	}
	public void mostrarVentana(){
		this.setVisible(true);
	}

	public JTextField getUsername() {
		return txtUsername;
	}
	public JPasswordField getPassword() {
		return passwordField;
	}
	public JButton getBtnIngresar() {
		return btnIngresar;
	}
}
