package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import dto.LocalidadDTO;
import dto.PaisDTO;

import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class VentanaAgregarPais extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static VentanaAgregarPais INSTANCE;
	private JPanel contentPane;
	private DefaultListModel<PaisDTO> modeloPais;
	private JList<PaisDTO> listaPais;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnEditar;
	
	
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
	
	public VentanaAgregarPais() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 469, 574);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(12, 42, 325, 519);
		panel.add(spPersonas);
		
		
		modeloPais = new DefaultListModel<PaisDTO>();
		
		listaPais = new JList<PaisDTO>(modeloPais);
		listaPais.setBounds(12, 555, 291, -509);
		listaPais.setVisibleRowCount(10);
		listaPais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		spPersonas.setViewportView(listaPais);
		
		JLabel lblLocalidades_1 = new JLabel("Localidades:");
		lblLocalidades_1.setBounds(12, 13, 79, 16);
		panel.add(lblLocalidades_1);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(360, 52, 97, 25);
		panel.add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(360, 90, 97, 25);
		panel.add(btnBorrar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(360, 128, 97, 25);
		panel.add(btnEditar);
			
	}
	
	public DefaultListModel<PaisDTO> getModeloLocalidad() {
		return modeloPais;
	}
	public PaisDTO getSeleccionada() {
		return (PaisDTO) this.listaPais.getSelectedValue();
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void llenarTabla(List<PaisDTO> paises) {
		this.modeloPais.removeAllElements();
		for(PaisDTO l : paises) {
			this.modeloPais.addElement(l);
		}
	
	}
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
}
