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
import dto.TipoContactoDTO;


public class VentanaAgregarTipo extends JFrame{
private static final long serialVersionUID = 1L;
	
	private static VentanaAgregarTipo INSTANCE;
	private JPanel contentPane;
	private DefaultListModel<TipoContactoDTO> modeloTipo;
	private JList<TipoContactoDTO> listaTipo;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnEditar;
	
	
	public static VentanaAgregarTipo getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaAgregarTipo(); 	
			return new VentanaAgregarTipo();
		}
		else
			return INSTANCE;
	}
	
	public VentanaAgregarTipo() {
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
		
		
		modeloTipo = new DefaultListModel<TipoContactoDTO>();
		
		listaTipo = new JList<TipoContactoDTO>(modeloTipo);
		listaTipo.setBounds(12, 555, 291, -509);
		listaTipo.setVisibleRowCount(10);
		listaTipo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		spPersonas.setViewportView(listaTipo);
		
		JLabel lblLocalidades_1 = new JLabel("Tipo de Contacto:");
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
	
	public DefaultListModel<TipoContactoDTO> getModeloTipo() {
		return modeloTipo;
	}
	public TipoContactoDTO getSeleccionada() {
		return (TipoContactoDTO) this.listaTipo.getSelectedValue();
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

	public void llenarTabla(List<TipoContactoDTO> tipo) {
		this.modeloTipo.removeAllElements();
		for(TipoContactoDTO l : tipo) {
			this.modeloTipo.addElement(l);
		}
	
	}
	public void mostrarVentana()
	{
		this.setVisible(true);
	}

}
