package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dto.DireccionDTO;
import dto.TipoContactoDTO;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.PersonaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
		private VentanaPersona ventanaPersona; 
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.ventanaPersona = VentanaPersona.getInstance();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			this.agenda = agenda;
		}
		
		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana();
			this.ventanaPersona.llenarTipos(this.agenda.obtenerTipoContactos());
			this.ventanaPersona.llenarPais(this.agenda.obtenerDirecciones());
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

			String stringTipo = (ventanaPersona.getTipoContacto().getSelectedItem() != null)? ventanaPersona.getTipoContacto().getSelectedItem().toString():"";
			TipoContactoDTO tipo = new TipoContactoDTO(0,stringTipo);

			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String email = ventanaPersona.getTxtEmail().getText();
			String fecha_nacimiento = ventanaPersona.getTxtCumpleaños().getText();
			System.out.println(pais);
			System.out.println(provincia);
			System.out.println(localidad);
			System.out.println(calle);
			System.out.println(altura);
			System.out.println(piso);
			System.out.println(depto);
			
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, email,null,direccion,tipo);
			this.agenda.agregarDireccion(direccion);
			this.agenda.agregarTipoContacto(tipo);
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
