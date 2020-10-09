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



public class VentanaLocalidad extends JFrame{
private static final long serialVersionUID = 1L;
	
	private static VentanaLocalidad INSTANCE;
	private JPanel contentPane;
	private DefaultListModel<String> modeloLocalidad;
	private JList<String> listaLocalidad;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnEditar;
	private JLabel lblProvincia;
	private JLabel lblPais;
	
	
	public static VentanaLocalidad getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaLocalidad(); 	
			return new VentanaLocalidad();
		}
		else
			return INSTANCE;
	}
	
	public VentanaLocalidad() {
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
		
		
		modeloLocalidad = new DefaultListModel<String>();
		
		listaLocalidad = new JList<String>(modeloLocalidad);
		listaLocalidad.setBounds(12, 555, 291, -509);
		listaLocalidad.setVisibleRowCount(10);
		listaLocalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		spPersonas.setViewportView(listaLocalidad);
		
		JLabel lblLocalidades_1 = new JLabel("Localidad de ");
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
		
		lblProvincia = new JLabel("");
		lblProvincia.setBounds(101, 14, 79, 14);
		panel.add(lblProvincia);
		
		lblPais = new JLabel("");
		lblPais.setBounds(184, 13, 79, 14);
		panel.add(lblPais);
			
	}
	
	public DefaultListModel<String> getModeloLocalidad() {
		return modeloLocalidad;
	}
	public String getSeleccionada() {
		return this.listaLocalidad.getSelectedValue().toString();
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
	
	public JLabel getProvincia() {
		return lblProvincia;
	}

	public void llenarTabla(List<PaisProvLocDTO> localidad, String pais, String provincia) {
		this.modeloLocalidad.removeAllElements();
		HashSet<String> set = new HashSet<>();
		lblPais.setText(pais);
		lblProvincia.setText(provincia);
		for(PaisProvLocDTO l : localidad) {
			if(!set.contains(l.getLocalidad()))
				if(l.getPais().equals(pais))
					if(l.getProvincia().equals(provincia))
					this.modeloLocalidad.addElement(l.getLocalidad());
			set.add(l.getLocalidad());
		}
	
	}
	public void mostrarVentana()
	{
		this.setVisible(true);
	}

}
