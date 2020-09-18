package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dto.DireccionDTO;
import dto.TipoContactoDTO;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaEditarPersona;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.PersonaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
		private VentanaPersona ventanaPersona;
		private VentanaEditarPersona ventanaEditarPersona;
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnEditar().addActionListener(b->ventanaEditarPersona(b));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.ventanaPersona = VentanaPersona.getInstance();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			this.ventanaEditarPersona = VentanaEditarPersona.getInstance();
			this.ventanaEditarPersona.getBtnEditarPersona().addActionListener(c->editarPersona(c));
			this.agenda = agenda;
		}
		
		private void editarPersona(ActionEvent c) {
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			
			int id = this.personasEnTabla.get(filasSeleccionadas[0]).getIdPersona();
			String pais = (ventanaEditarPersona.getPais().getSelectedItem() != null)? ventanaEditarPersona.getPais().getSelectedItem().toString():"";
			String provincia = (ventanaEditarPersona.getProvincia().getSelectedItem() != null)? ventanaEditarPersona.getProvincia().getSelectedItem().toString():"";
			String localidad = (ventanaEditarPersona.getLocalidad().getSelectedItem() != null)? ventanaEditarPersona.getLocalidad().getSelectedItem().toString():"";
			String calle = ventanaEditarPersona.getTxtCalle().getText();
			String altura = ventanaEditarPersona.getTxtAltura().getText();
			String piso = ventanaEditarPersona.getTxtPiso().getText();
			String depto = ventanaEditarPersona.getTxtDepto().getText();
			DireccionDTO direccion = new DireccionDTO(0,pais, provincia, localidad, calle, altura, piso, depto);

			TipoContactoDTO tipo = (TipoContactoDTO) ventanaEditarPersona.getTipoContacto().getSelectedItem();

			String nombre = this.ventanaEditarPersona.getTxtNombre().getText();
			String tel = ventanaEditarPersona.getTxtTelefono().getText();
			String email = ventanaEditarPersona.getTxtEmail().getText();
			String fecha_nacimiento = ventanaEditarPersona.getTxtCumpleaños().getText();			
			
			this.agenda.agregarDireccion(direccion);
			DireccionDTO ultimaDir = this.agenda.ultimaDireccion();
			PersonaDTO nuevaPersona = new PersonaDTO(id, nombre, tel, email,null,ultimaDir,ventanaEditarPersona.getTipo());
			this.agenda.editarPersona(nuevaPersona);
			this.refrescarTabla();
			this.ventanaEditarPersona.cerrar();
			
		}

		private void ventanaEditarPersona(ActionEvent b) 
		{
			this.ventanaEditarPersona.llenarTipos(this.agenda.obtenerTipoContactos());
			this.ventanaEditarPersona.llenarPais(this.agenda.obtenerDirecciones());
			this.ventanaEditarPersona.llenarProvincia(this.agenda.obtenerDirecciones());
			this.ventanaEditarPersona.llenarLocalidad(this.agenda.obtenerDirecciones());
			
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			
			if(filasSeleccionadas.length!=1) {
				JOptionPane.showMessageDialog(ventanaEditarPersona, "Debe elejir un único contacto para poder editarlo");
			}
			else 
			{
				
				this.ventanaEditarPersona.mostrarVentana();
				this.ventanaEditarPersona.getTxtNombre().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getNombre());
				this.ventanaEditarPersona.getTxtTelefono().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getTelefono());
				this.ventanaEditarPersona.getTxtAltura().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getAltura());
				this.ventanaEditarPersona.getTxtCalle().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getCalle());
				this.ventanaEditarPersona.getTxtDepto().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getDepartamento());
				this.ventanaEditarPersona.getTxtEmail().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getEmail());
				this.ventanaEditarPersona.getTxtPiso().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getPiso());
				this.ventanaEditarPersona.getPais().setSelectedItem(this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getPais());
				this.ventanaEditarPersona.getProvincia().setSelectedItem(this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getProvincia());
				this.ventanaEditarPersona.getLocalidad().setSelectedItem(this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getLocalidad());
				this.ventanaEditarPersona.getTipoContacto().setSelectedItem(this.personasEnTabla.get(filasSeleccionadas[0]).getTipoContacto());
			}
		}

		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana();
			this.ventanaPersona.llenarTipos(this.agenda.obtenerTipoContactos());
			this.ventanaPersona.llenarPais(this.agenda.obtenerDirecciones());
			this.ventanaPersona.llenarProvincia(this.agenda.obtenerDirecciones());
			this.ventanaPersona.llenarLocalidad(this.agenda.obtenerDirecciones());
		}

		private void guardarPersona(ActionEvent p) {
			String pais = (ventanaPersona.getPais().getSelectedItem() != null)? ventanaPersona.getPais().getSelectedItem().toString():"";
			String provincia = (ventanaPersona.getProvincia().getSelectedItem() != null)? ventanaPersona.getProvincia().getSelectedItem().toString():"";
			String localidad = (ventanaPersona.getLocalidad().getSelectedItem() != null)? ventanaPersona.getLocalidad().getSelectedItem().toString():"";
			String calle = ventanaPersona.getTxtCalle().getText();
			String altura = ventanaPersona.getTxtAltura().getText();
			String piso = ventanaPersona.getTxtPiso().getText();
			String depto = ventanaPersona.getTxtDepto().getText();
			DireccionDTO direccion = new DireccionDTO(0,pais, provincia, localidad, calle, altura, piso, depto);

			TipoContactoDTO tipo = (TipoContactoDTO) ventanaPersona.getTipoContacto().getSelectedItem();

			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String email = ventanaPersona.getTxtEmail().getText();
			String fecha_nacimiento = ventanaPersona.getTxtCumpleaños().getText();			
			
			this.agenda.agregarDireccion(direccion);
			DireccionDTO ultimaDir = this.agenda.ultimaDireccion();
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, email,null,ultimaDir,ventanaPersona.getTipo());
			this.agenda.agregarPersona(nuevaPersona);
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
		}

		private void mostrarReporte(ActionEvent r) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();	
		}

		public void borrarPersona(ActionEvent s)
		{
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				this.agenda.borrarPersona(this.personasEnTabla.get(fila));
			}
			
			this.refrescarTabla();
		}
		
		public void inicializar()
		{
			this.refrescarTabla();
			this.vista.show();
		}
		
		private void refrescarTabla()
		{
			this.personasEnTabla = agenda.obtenerPersonas();
			this.vista.llenarTabla(this.personasEnTabla);
		}

		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
