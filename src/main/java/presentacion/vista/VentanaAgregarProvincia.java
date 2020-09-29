package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import dto.ProvinciaDTO;


public class VentanaAgregarProvincia extends JFrame{
private static final long serialVersionUID = 1L;
	
	private static VentanaAgregarProvincia INSTANCE;
	private JPanel contentPane;
	private DefaultListModel<ProvinciaDTO> modeloProvincia;
	private JList<ProvinciaDTO> listaProvincia;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnEditar;
	
	
	public static VentanaAgregarProvincia getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaAgregarProvincia(); 	
			return new VentanaAgregarProvincia();
		}
		else
			return INSTANCE;
	}
	
	public VentanaAgregarProvincia() {
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
		
		
		modeloProvincia = new DefaultListModel<ProvinciaDTO>();
		
		listaProvincia = new JList<ProvinciaDTO>(modeloProvincia);
		listaProvincia.setBounds(12, 555, 291, -509);
		listaProvincia.setVisibleRowCount(10);
		listaProvincia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		spPersonas.setViewportView(listaProvincia);
		
		JLabel lblLocalidades_1 = new JLabel("Provincias:");
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
	
	public DefaultListModel<ProvinciaDTO> getModeloProvincia() {
		return modeloProvincia;
	}
	public ProvinciaDTO getSeleccionada() {
		return (ProvinciaDTO) this.listaProvincia.getSelectedValue();
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

	public void llenarTabla(List<ProvinciaDTO> provincia) {
		this.modeloProvincia.removeAllElements();
		for(ProvinciaDTO l : provincia) {
			this.modeloProvincia.addElement(l);
		}
	
	}
	public void mostrarVentana()
	{
		this.setVisible(true);
	}

}
