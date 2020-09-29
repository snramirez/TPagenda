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
import dto.LocalidadDTO;



public class VentanaAgregarLocalidad extends JFrame{
private static final long serialVersionUID = 1L;
	
	private static VentanaAgregarLocalidad INSTANCE;
	private JPanel contentPane;
	private DefaultListModel<LocalidadDTO> modeloLocalidad;
	private JList<LocalidadDTO> listaLocalidad;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnEditar;
	
	
	public static VentanaAgregarLocalidad getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaAgregarLocalidad(); 	
			return new VentanaAgregarLocalidad();
		}
		else
			return INSTANCE;
	}
	
	public VentanaAgregarLocalidad() {
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
		
		
		modeloLocalidad = new DefaultListModel<LocalidadDTO>();
		
		listaLocalidad = new JList<LocalidadDTO>(modeloLocalidad);
		listaLocalidad.setBounds(12, 555, 291, -509);
		listaLocalidad.setVisibleRowCount(10);
		listaLocalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		spPersonas.setViewportView(listaLocalidad);
		
		JLabel lblLocalidades_1 = new JLabel("Localidad:");
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
	
	public DefaultListModel<LocalidadDTO> getModeloLocalidad() {
		return modeloLocalidad;
	}
	public LocalidadDTO getSeleccionada() {
		return (LocalidadDTO) this.listaLocalidad.getSelectedValue();
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

	public void llenarTabla(List<LocalidadDTO> localidad) {
		this.modeloLocalidad.removeAllElements();
		for(LocalidadDTO l : localidad) {
			this.modeloLocalidad.addElement(l);
		}
	
	}
	public void mostrarVentana()
	{
		this.setVisible(true);
	}

}
