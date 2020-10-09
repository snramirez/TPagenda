package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.util.HashSet;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import dto.PaisProvLocDTO;


public class VentanaProvincia extends JFrame{
private static final long serialVersionUID = 1L;
	
	private static VentanaProvincia INSTANCE;
	private JPanel contentPane;
	private DefaultListModel<String> modeloProvincia;
	private JList<String> listaProvincia;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnEditar;
	private JLabel lblPais;
	
	
	public static VentanaProvincia getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaProvincia(); 	
			return new VentanaProvincia();
		}
		else
			return INSTANCE;
	}
	
	public VentanaProvincia() {
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
		
		
		modeloProvincia = new DefaultListModel<String>();
		
		listaProvincia = new JList<String>(modeloProvincia);
		listaProvincia.setBounds(12, 555, 291, -509);
		listaProvincia.setVisibleRowCount(10);
		listaProvincia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		spPersonas.setViewportView(listaProvincia);
		
		JLabel lblLocalidades_1 = new JLabel("Provincias de ");
		lblLocalidades_1.setBounds(12, 13, 87, 16);
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
		
		lblPais = new JLabel("");
		lblPais.setBounds(97, 13, 55, 14);
		panel.add(lblPais);
			
	}
	
	public DefaultListModel<String> getModeloProvincia() {
		return modeloProvincia;
	}
	public String getSeleccionada() {
		return this.listaProvincia.getSelectedValue().toString();
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
	
	public JLabel getPais() {
		return lblPais;
	}

	public void llenarTabla(List<PaisProvLocDTO> provincia, String pais) {
		this.modeloProvincia.removeAllElements();
		HashSet<String> set = new HashSet<>();
		lblPais.setText(pais);
		for(PaisProvLocDTO l : provincia) {
			if(!set.contains(l.getProvincia()))
				if(l.getPais().equals(pais))
					this.modeloProvincia.addElement(l.getProvincia());
			set.add(l.getProvincia());
		}
	
	}
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
}
