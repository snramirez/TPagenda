package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dto.DireccionDTO;
import dto.LocalidadDTO;
import dto.PaisDTO;
import dto.PaisProvLocDTO;
import dto.TipoContactoDTO;
import modelo.Agenda;
import persistencia.conexion.Conexion;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPais;
import presentacion.vista.VentanaProvincia;
import presentacion.vista.VentanaTipo;
import presentacion.vista.Login;
import presentacion.vista.VentanaAgregarLocalidad;
import presentacion.vista.VentanaAgregarPais;
import presentacion.vista.VentanaAgregarProvincia;
import presentacion.vista.VentanaAgregarTipo;
import presentacion.vista.VentanaEditarLocalidad;
import presentacion.vista.VentanaEditarPais;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaEditarPersona;
import presentacion.vista.VentanaEditarProvincia;
import presentacion.vista.VentanaEditarTipo;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.PersonaDTO;
import dto.ProvinciaDTO;

public class Controlador implements ActionListener
{
		private Login login;
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
		private VentanaPersona ventanaPersona;
		private VentanaEditarPersona ventanaEditarPersona;
		private VentanaPais ventanaPais;
		private VentanaAgregarPais ventanaAgregarPais;
		private VentanaEditarPais ventanaEditarPais;
		private VentanaProvincia ventanaProvincia;
		private VentanaAgregarProvincia ventanaAgregarProvincia;
		private VentanaEditarProvincia ventanaEditarProvincia;
		private VentanaLocalidad ventanaLocalidad;
		private VentanaAgregarLocalidad ventanaAgregarLocalidad;
		private VentanaEditarLocalidad ventanaEditarLocalidad;
		private VentanaTipo ventanaTipo;
		private VentanaAgregarTipo ventanaAgregarTipo;
		private VentanaEditarTipo ventanaEditarTipo;
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.login = Login.getInstance();
			this.login.getBtnIngresar().addActionListener(i -> validarDatos(i));
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnEditar().addActionListener(b->ventanaEditarPersona(b));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			
			this.ventanaPersona = VentanaPersona.getInstance();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			this.ventanaPersona.getBtnEditarPais().addActionListener(d->ventanaPais(d));
			this.ventanaPersona.getBtnEditarProv().addActionListener(f->ventanaProv(f, this.ventanaPersona.getPais().getSelectedItem().toString()));
			this.ventanaPersona.getBtnEditarLoc().addActionListener(g->ventanaLoc(g, this.ventanaPersona.getPais().getSelectedItem().toString(), this.ventanaPersona.getProvincia().getSelectedItem().toString()));
			this.ventanaPersona.getBtnEditarTipo().addActionListener(h->ventanaTipo(h));
			this.ventanaPersona.getPais().addActionListener(l->cargarPais(l));
			this.ventanaPersona.getProvincia().addActionListener(l->cargarProv(l));
			
			this.ventanaEditarPersona = VentanaEditarPersona.getInstance();
			this.ventanaEditarPersona.getBtnEditarPersona().addActionListener(c->editarPersona(c));
			this.ventanaEditarPersona.getBtnEditarPais().addActionListener(d->ventanaPais(d));
			this.ventanaEditarPersona.getBtnEditarProv().addActionListener(f->ventanaProv(f,this.ventanaEditarPersona.getPais().getSelectedItem().toString()));
			this.ventanaEditarPersona.getBtnEditarLoc().addActionListener(g->ventanaLoc(g, this.ventanaEditarPersona.getPais().getSelectedItem().toString(), this.ventanaEditarPersona.getProvincia().getSelectedItem().toString()));
			this.ventanaEditarPersona.getBtnEditarTipo().addActionListener(h->ventanaTipo(h));
			this.ventanaEditarPersona.getPais().addActionListener(l->cargarPaisVE(l));
			this.ventanaEditarPersona.getProvincia().addActionListener(l->cargarProvVE(l));
			
			this.ventanaPais = VentanaPais.getInstance();
			this.ventanaAgregarPais =VentanaAgregarPais.getInstance();
			this.ventanaEditarPais = VentanaEditarPais.getInstance();
			this.ventanaPais.getBtnAgregar().addActionListener(j->ventanaAgregarPais(j));
			this.ventanaPais.getBtnEditar().addActionListener(j->ventanaEditarPais(j));
			this.ventanaPais.getBtnBorrar().addActionListener(j->borrarPais(j));
			this.ventanaAgregarPais.getBtnAñadir().addActionListener(k->AgregarPais(k));
			this.ventanaEditarPais.getBtnEditar().addActionListener(k->EditarPais(k));
			
			this.ventanaProvincia = VentanaProvincia.getInstance();
			this.ventanaAgregarProvincia =VentanaAgregarProvincia.getInstance();
			this.ventanaEditarProvincia = VentanaEditarProvincia.getInstance();
			this.ventanaProvincia.getBtnAgregar().addActionListener(j->ventanaAgregarProvincia(j));
			this.ventanaProvincia.getBtnEditar().addActionListener(j->ventanaEditarProvincia(j));
			this.ventanaProvincia.getBtnBorrar().addActionListener(j->borrarProvincia(j));
			this.ventanaAgregarProvincia.getBtnAñadir().addActionListener(k->AgregarProvincia(k));
			this.ventanaEditarProvincia.getBtnEditar().addActionListener(k->EditarProvincia(k));
			
			this.ventanaLocalidad = VentanaLocalidad.getInstance();
			this.ventanaAgregarLocalidad =VentanaAgregarLocalidad.getInstance();
			this.ventanaEditarLocalidad = VentanaEditarLocalidad.getInstance();
			this.ventanaLocalidad.getBtnAgregar().addActionListener(j->ventanaAgregarLocalidad(j));
			this.ventanaLocalidad.getBtnEditar().addActionListener(j->ventanaEditarLocalidad(j));
			this.ventanaLocalidad.getBtnBorrar().addActionListener(j->borrarLocalidad(j));
			this.ventanaAgregarLocalidad.getBtnAñadir().addActionListener(k->AgregarLocalidad(k));
			this.ventanaEditarLocalidad.getBtnEditar().addActionListener(k->EditarLocalidad(k));
			
			this.ventanaTipo = VentanaTipo.getInstance();
			this.ventanaAgregarTipo =VentanaAgregarTipo.getInstance();
			this.ventanaEditarTipo = VentanaEditarTipo.getInstance();
			this.ventanaTipo.getBtnAgregar().addActionListener(j->ventanaAgregarTipo(j));
			this.ventanaTipo.getBtnEditar().addActionListener(j->ventanaEditarTipo(j));
			this.ventanaTipo.getBtnBorrar().addActionListener(j->borrarTipo(j));
			this.ventanaAgregarTipo.getBtnAñadir().addActionListener(k->AgregarTipo(k));
			this.ventanaEditarTipo.getBtnEditar().addActionListener(k->EditarTipo(k));
			
			this.agenda = agenda;
		}
			
		private  void cargarPais(ActionEvent l) {
			if(this.ventanaPersona.getPais().getSelectedItem() != null) {
				String paisSelect = this.ventanaPersona.getPais().getSelectedItem().toString();
				this.ventanaPersona.llenarProvincia(this.agenda.obtenerPaisProvLoc(), paisSelect);
			}
		}
		
		private  void cargarProv(ActionEvent l) {
			String paisSelect = this.ventanaPersona.getPais().getSelectedItem().toString();
			if(this.ventanaPersona.getProvincia().getSelectedItem() != null) {
				String provSelect = this.ventanaPersona.getProvincia().getSelectedItem().toString();
				this.ventanaPersona.llenarLocalidad(this.agenda.obtenerPaisProvLoc(), paisSelect, provSelect);
			}
		}
		
		private  void cargarPaisVE(ActionEvent l) {
			if(this.ventanaEditarPersona.getPais().getSelectedItem() != null) {
				String paisSelect = this.ventanaEditarPersona.getPais().getSelectedItem().toString();
				this.ventanaEditarPersona.llenarProvincia(this.agenda.obtenerPaisProvLoc(), paisSelect);
			}
		}
		
		private  void cargarProvVE(ActionEvent l) {
			String paisSelect = this.ventanaEditarPersona.getPais().getSelectedItem().toString();
			if(this.ventanaEditarPersona.getProvincia().getSelectedItem() != null) {
				String provSelect = this.ventanaEditarPersona.getProvincia().getSelectedItem().toString();
				this.ventanaEditarPersona.llenarLocalidad(this.agenda.obtenerPaisProvLoc(), paisSelect, provSelect);
			}
		}
		

		private void ventanaProv(ActionEvent d, String pais) {
			this.ventanaProvincia.llenarTabla(this.agenda.obtenerPaisProvLoc(), pais);
			this.ventanaProvincia.mostrarVentana();	
		}

		private void ventanaLoc(ActionEvent d, String pais, String provincia) {
			this.ventanaLocalidad.llenarTabla(this.agenda.obtenerPaisProvLoc(), pais, provincia);
			this.ventanaLocalidad.mostrarVentana();	
		}

		private void ventanaTipo(ActionEvent d) {
			this.ventanaTipo.llenarTabla(this.agenda.obtenerTipoContactos());
			this.ventanaTipo.mostrarVentana();
		}

		private void validarDatos(ActionEvent i) {
			if (Conexion.verificarCredenciales(this.login.getUsername().getText(),String.valueOf(this.login.getPassword().getPassword()))){
				this.refrescarTabla();
				this.vista.show();
				this.login.dispose();
			}
		}
		
		private void ventanaPais(ActionEvent d) {
			this.ventanaPais.llenarTabla(this.agenda.obtenerPaisProvLoc());
			this.ventanaPais.mostrarVentana();
			
		}
		
		private void ventanaAgregarPais(ActionEvent j) {
			this.ventanaAgregarPais.mostrarVentana();
			
		}
		
		private void ventanaEditarPais(ActionEvent j) {
			this.ventanaEditarPais.getNombrePais().setText(this.ventanaPais.getSeleccionada());
			this.ventanaEditarPais.mostrarVentana();
			
		}
		
		private void AgregarPais(ActionEvent k) {
			if (this.ventanaAgregarPais.getNombrePais().getText().length() == 0) {
				JOptionPane.showMessageDialog(ventanaPersona, "Debe Ingresar el nombre del pais");
			}else {
				
			// Añado la nueva localidad ingresada
			PaisProvLocDTO paisNuevo = new PaisProvLocDTO(0, this.ventanaAgregarPais.getNombrePais().getText(),"","");
			this.agenda.agregarPaisProvLoc(paisNuevo);
	
			// recargo los combos y cierro la ventana
			this.ventanaPersona.llenarPais(this.agenda.obtenerPaisProvLoc());
			//this.ventanaEditarPersona.llenarPais(this.agenda.obtenerPaisProvLoc());
			this.ventanaPais.llenarTabla(this.agenda.obtenerPaisProvLoc());
			this.ventanaAgregarPais.cerrar();
			}
		}
		
		private void EditarPais(ActionEvent k) {
			if (this.ventanaEditarPais.getNombrePais().getText().length() == 0) {
				JOptionPane.showMessageDialog(ventanaPersona, "Debe Ingresar el nombre del pais");
			}else {
				
			// Añado la nueva localidad ingresada
				PaisProvLocDTO paisNuevo = new PaisProvLocDTO(0, this.ventanaPais.getSeleccionada(), "", "");
			
			this.agenda.editarPais(paisNuevo, this.ventanaEditarPais.getNombrePais().getText());
			
			// recargo los combos y cierro la ventana
			this.ventanaPersona.llenarPais(this.agenda.obtenerPaisProvLoc());
			//this.ventanaEditarPersona.llenarPais(this.agenda.obtenerPaisProvLoc());
			this.ventanaPais.llenarTabla(this.agenda.obtenerPaisProvLoc());
			this.ventanaEditarPais.cerrar();
			this.refrescarTabla();
			}
		}
		
		private void borrarPais(ActionEvent a) {
			if (this.ventanaPais.getSeleccionada() == null) {
				JOptionPane.showMessageDialog(this.ventanaPais, "Debe seleccionar un pais");
			}else {
				if(JOptionPane.showConfirmDialog(null , "¿Esta seguro que desea borrar este pais") == 0) {
					PaisProvLocDTO pais = new PaisProvLocDTO(0, this.ventanaPais.getSeleccionada(),"","");
					this.agenda.borrarPais(pais);

					this.ventanaPersona.llenarPais(this.agenda.obtenerPaisProvLoc());
					//this.ventanaEditarPersona.llenarPais(this.agenda.obtenerPaisProvLoc());
					this.ventanaPais.llenarTabla(this.agenda.obtenerPaisProvLoc());
				}
			}
		}
		
		private void ventanaAgregarProvincia(ActionEvent j) {
			this.ventanaAgregarProvincia.mostrarVentana();
			
		}
		
		private void ventanaEditarProvincia(ActionEvent j) {
			this.ventanaEditarProvincia.getNombreProvincia().setText(this.ventanaProvincia.getSeleccionada());
			this.ventanaEditarProvincia.mostrarVentana();
		}
		
		private void AgregarProvincia(ActionEvent k) {
			if (this.ventanaAgregarProvincia.getNombreProvincia().getText().length() == 0) {
				JOptionPane.showMessageDialog(ventanaPersona, "Debe Ingresar el nombre de la provincia");
			}else {
				
			// Añado la nueva localidad ingresada
			String pais = this.ventanaProvincia.getPais().getText();
			PaisProvLocDTO provinciaNueva = new PaisProvLocDTO(0, pais, this.ventanaAgregarProvincia.getNombreProvincia().getText(), "");
			this.agenda.agregarPaisProvLoc(provinciaNueva);
			
			// recargo los combos y cierro la ventana
			this.ventanaPersona.llenarProvincia(this.agenda.obtenerPaisProvLoc(), pais);
			//this.ventanaEditarPersona.llenarProvincia(this.agenda.obtenerPaisProvLoc());
			this.ventanaProvincia.llenarTabla(this.agenda.obtenerPaisProvLoc(), pais);
			this.ventanaAgregarProvincia.cerrar();
			}
			
		}
		
		private void EditarProvincia(ActionEvent k) {
			if (this.ventanaEditarProvincia.getNombreProvincia().getText().length() == 0) {
				JOptionPane.showMessageDialog(ventanaPersona, "Debe Ingresar el nombre de la Provincia");
			}else {
				
			// Añado la nueva localidad ingresada
				String pais = this.ventanaProvincia.getPais().getText();
				PaisProvLocDTO ProvinciaNuevo = new PaisProvLocDTO(0, pais, this.ventanaProvincia.getSeleccionada(), "");
			
			this.agenda.editarProvincia(ProvinciaNuevo, this.ventanaEditarProvincia.getNombreProvincia().getText());
			
			// recargo los combos y cierro la ventana
			this.ventanaPersona.llenarProvincia(this.agenda.obtenerPaisProvLoc(), pais);
			//this.ventanaEditarPersona.llenarProvincia(this.agenda.obtenerPaisProvLoc());
			this.ventanaProvincia.llenarTabla(this.agenda.obtenerPaisProvLoc(), pais);
			this.ventanaEditarProvincia.cerrar();
			this.refrescarTabla();
			}
		}
		
		private void borrarProvincia(ActionEvent a) {
			if (this.ventanaProvincia.getSeleccionada() == null) {
				JOptionPane.showMessageDialog(this.ventanaProvincia, "Debe seleccionar una Provincia");
			}else {
				if(JOptionPane.showConfirmDialog(null , "¿Esta seguro que desea borrar esta Provincia?") == 0) {
					String pais = this.ventanaProvincia.getPais().getText();
					PaisProvLocDTO ProvinciaBorrar = new PaisProvLocDTO(0, pais, this.ventanaProvincia.getSeleccionada(), "");
					this.agenda.borrarProvincia(ProvinciaBorrar);

					this.ventanaPersona.llenarProvincia(this.agenda.obtenerPaisProvLoc(), pais);
					//this.ventanaEditarPersona.llenarProvincia(this.agenda.obtenerPaisProvLoc());
					this.ventanaProvincia.llenarTabla(this.agenda.obtenerPaisProvLoc(), pais);
				}
			}
		}
		
		private void ventanaAgregarLocalidad(ActionEvent j) {
			this.ventanaAgregarLocalidad.mostrarVentana();
			
		}
		
		private void ventanaEditarLocalidad(ActionEvent j) {
			this.ventanaEditarLocalidad.getNombreLocalidad().setText(this.ventanaLocalidad.getSeleccionada());
			this.ventanaEditarLocalidad.mostrarVentana();
			
		}
		
		private void AgregarLocalidad(ActionEvent k) {
			if (this.ventanaAgregarLocalidad.getNombreLocalidad().getText().length() == 0) {
				JOptionPane.showMessageDialog(ventanaPersona, "Debe Ingresar el nombre de la Localidad");
			}else {
				
			// Añado la nueva localidad ingresada
			String pais = this.ventanaLocalidad.getPais().getText();
			String provincia = this.ventanaLocalidad.getProvincia().getText();
			PaisProvLocDTO localidadNueva = new PaisProvLocDTO(0, pais, provincia, this.ventanaAgregarLocalidad.getNombreLocalidad().getText());
			this.agenda.agregarPaisProvLoc(localidadNueva);
			
			// recargo los combos y cierro la ventana
			this.ventanaPersona.llenarLocalidad(this.agenda.obtenerPaisProvLoc(), pais, provincia);
			//this.ventanaEditarPersona.llenarLocalidad(this.agenda.obtenerPaisProvLoc());
			this.ventanaLocalidad.llenarTabla(this.agenda.obtenerPaisProvLoc(), pais, provincia);
			this.ventanaAgregarLocalidad.cerrar();
			}
		}
		
		private void EditarLocalidad(ActionEvent k) {
			if (this.ventanaEditarLocalidad.getNombreLocalidad().getText().length() == 0) {
				JOptionPane.showMessageDialog(ventanaPersona, "Debe Ingresar el nombre de la Localidad");
			}else {
				
			// Añado la nueva localidad ingresada
			String pais = this.ventanaLocalidad.getPais().getText();
			String provincia = this.ventanaLocalidad.getProvincia().getText();
			PaisProvLocDTO LocalidadNuevo = new PaisProvLocDTO(0, pais, provincia, this.ventanaLocalidad.getSeleccionada());
			
			this.agenda.editarLocalidad(LocalidadNuevo, this.ventanaEditarLocalidad.getNombreLocalidad().getText());
			
			// recargo los combos y cierro la ventana
			this.ventanaPersona.llenarLocalidad(this.agenda.obtenerPaisProvLoc(), pais, provincia);
			//this.ventanaEditarPersona.llenarLocalidad(this.agenda.obtenerPaisProvLoc());
			this.ventanaLocalidad.llenarTabla(this.agenda.obtenerPaisProvLoc(), pais, provincia);
			this.ventanaEditarLocalidad.cerrar();
			this.refrescarTabla();
			}
		}
		
		private void borrarLocalidad(ActionEvent a) {
			if (this.ventanaLocalidad.getSeleccionada() == null) {
				JOptionPane.showMessageDialog(this.ventanaLocalidad, "Debe seleccionar una Localidad");
			}else {
				if(JOptionPane.showConfirmDialog(null , "¿Esta seguro que desea borrar esta Localidad?") == 0) {
					String pais = this.ventanaLocalidad.getPais().getText();
					String provincia = this.ventanaLocalidad.getProvincia().getText();
					PaisProvLocDTO LocalidadNuevo = new PaisProvLocDTO(0, pais, provincia, this.ventanaLocalidad.getSeleccionada());
					this.agenda.borrarLocalidad(LocalidadNuevo);

					this.ventanaPersona.llenarLocalidad(this.agenda.obtenerPaisProvLoc(), pais, provincia);
					//this.ventanaEditarPersona.llenarLocalidad(this.agenda.obtenerPaisProvLoc());
					this.ventanaLocalidad.llenarTabla(this.agenda.obtenerPaisProvLoc(), pais, provincia);
				}
			}
		}
		
		private void ventanaAgregarTipo(ActionEvent j) {
			this.ventanaAgregarTipo.mostrarVentana();	
		}
		
		private void ventanaEditarTipo(ActionEvent j) {
			this.ventanaEditarTipo.getNombreTipo().setText(this.ventanaTipo.getSeleccionada().getNombreTipoContacto());
			this.ventanaEditarTipo.mostrarVentana();	
		}
		
		private void AgregarTipo(ActionEvent k) {
			if (this.ventanaAgregarTipo.getNombreTipo().getText().length() == 0) {
				JOptionPane.showMessageDialog(ventanaPersona, "Debe Ingresar el tipo de contacto");
			}else {
				
			// Añado la nueva localidad ingresada
			TipoContactoDTO tipoNuevo = new TipoContactoDTO(0, this.ventanaAgregarTipo.getNombreTipo().getText());
			this.agenda.agregarTipoContacto(tipoNuevo);
			
			// recargo los combos y cierro la ventana
			this.ventanaPersona.llenarTipos(this.agenda.obtenerTipoContactos());
			this.ventanaEditarPersona.llenarTipos(this.agenda.obtenerTipoContactos());
			this.ventanaTipo.llenarTabla(this.agenda.obtenerTipoContactos());
			this.ventanaAgregarTipo.cerrar();
			}
		}
		
		private void EditarTipo(ActionEvent k) {
			if (this.ventanaEditarTipo.getNombreTipo().getText().length() == 0) {
				JOptionPane.showMessageDialog(ventanaPersona, "Debe Ingresar el tipo de contacto");
			}else {
				
			// Añado la nueva localidad ingresada
				TipoContactoDTO tipoNuevo = new TipoContactoDTO(this.ventanaTipo.getSeleccionada().getIdTipoContacto(), this.ventanaEditarTipo.getNombreTipo().getText());
			
			this.agenda.editarTipoContacto(tipoNuevo);
			
			// recargo los combos y cierro la ventana
			this.ventanaPersona.llenarTipos(this.agenda.obtenerTipoContactos());
			this.ventanaEditarPersona.llenarTipos(this.agenda.obtenerTipoContactos());
			this.ventanaTipo.llenarTabla(this.agenda.obtenerTipoContactos());
			this.ventanaEditarTipo.cerrar();
			this.refrescarTabla();
			}
		}
		
		private void borrarTipo(ActionEvent a) {
			if (this.ventanaTipo.getSeleccionada() == null) {
				JOptionPane.showMessageDialog(this.ventanaTipo, "Debe seleccionar un tipo de contacto");
			}else {
				if(JOptionPane.showConfirmDialog(null , "¿Esta seguro que desea borrar este tipo de contacto?") == 0) {
					this.agenda.borrarTipoContacto(this.ventanaTipo.getSeleccionada());

					this.ventanaPersona.llenarTipos(this.agenda.obtenerTipoContactos());
					this.ventanaEditarPersona.llenarTipos(this.agenda.obtenerTipoContactos());
					this.ventanaTipo.llenarTabla(this.agenda.obtenerTipoContactos());
				}
			}
		}

		private void editarPersona(ActionEvent c) {
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			
			int id = this.personasEnTabla.get(filasSeleccionadas[0]).getIdPersona();
			String pais = (ventanaEditarPersona.getPais().getSelectedItem() != null)? ventanaEditarPersona.getPais().getSelectedItem().toString():"";
			String provincia = (ventanaEditarPersona.getProvincia().getSelectedItem() != null)? ventanaEditarPersona.getProvincia().getSelectedItem().toString():"";
			String localidad = (ventanaEditarPersona.getLocalidad().getSelectedItem() != null)? ventanaEditarPersona.getLocalidad().getSelectedItem().toString():"";
			String codigoPostal = ventanaEditarPersona.getCodigoPostal().getText();
			String calle = ventanaEditarPersona.getTxtCalle().getText();
			String altura = ventanaEditarPersona.getTxtAltura().getText();
			String piso = ventanaEditarPersona.getTxtPiso().getText();
			String depto = ventanaEditarPersona.getTxtDepto().getText();
			DireccionDTO direccion = new DireccionDTO(0,pais, provincia, localidad, codigoPostal, calle, altura, piso, depto);


			String nombre = this.ventanaEditarPersona.getTxtNombre().getText();
			String tel = ventanaEditarPersona.getTxtTelefono().getText();
			String email = ventanaEditarPersona.getTxtEmail().getText();
			String userLinkedin = ventanaEditarPersona.getLinkedin().getText();
			String fecha_nacimiento = ventanaEditarPersona.getTxtCumpleaños().getText();			
			
			this.agenda.agregarDireccion(direccion);
			DireccionDTO ultimaDir = this.agenda.ultimaDireccion();
			PersonaDTO nuevaPersona = new PersonaDTO(id, nombre, tel, email,userLinkedin,fecha_nacimiento,ultimaDir,ventanaEditarPersona.getTipo());
			this.agenda.editarPersona(nuevaPersona);
			this.refrescarTabla();
			this.ventanaEditarPersona.cerrar();
			
		}

		private void ventanaEditarPersona(ActionEvent b) 
		{
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			String pais = this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getPais();
			String provincia = this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getProvincia();
			this.ventanaEditarPersona.llenarTipos(this.agenda.obtenerTipoContactos());
			this.ventanaEditarPersona.llenarPais(this.agenda.obtenerPaisProvLoc());
			this.ventanaEditarPersona.llenarProvincia(this.agenda.obtenerPaisProvLoc(), pais);
			this.ventanaEditarPersona.llenarLocalidad(this.agenda.obtenerPaisProvLoc(), pais, provincia);
			
			
			
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
				this.ventanaEditarPersona.getTxtCumpleaños().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getFecha_nacimiento());
				this.ventanaEditarPersona.getTxtPiso().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getPiso());
				this.ventanaEditarPersona.getPais().setSelectedItem(this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getPais());
				this.ventanaEditarPersona.getProvincia().setSelectedItem(this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getProvincia());
				this.ventanaEditarPersona.getLocalidad().setSelectedItem(this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getLocalidad());
				this.ventanaEditarPersona.getCodigoPostal().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getDireccion().getCodigoPostal());
				this.ventanaEditarPersona.getLinkedin().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getUserLinkedin());
				this.ventanaEditarPersona.getTipoContacto().setSelectedItem(this.personasEnTabla.get(filasSeleccionadas[0]).getTipoContacto());
			}
		}

		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana();
			this.ventanaPersona.llenarTipos(this.agenda.obtenerTipoContactos());
			this.ventanaPersona.llenarPais(this.agenda.obtenerPaisProvLoc());
		}

		private void guardarPersona(ActionEvent p) {
			String pais = (ventanaPersona.getPais().getSelectedItem() != null)? ventanaPersona.getPais().getSelectedItem().toString():"";
			String provincia = (ventanaPersona.getProvincia().getSelectedItem() != null)? ventanaPersona.getProvincia().getSelectedItem().toString():"";
			String localidad = (ventanaPersona.getLocalidad().getSelectedItem() != null)? ventanaPersona.getLocalidad().getSelectedItem().toString():"";
			String codigoPostal = ventanaPersona.getCodigoPostal().getText();
			String calle = ventanaPersona.getTxtCalle().getText();
			String altura = ventanaPersona.getTxtAltura().getText();
			String piso = ventanaPersona.getTxtPiso().getText();
			String depto = ventanaPersona.getTxtDepto().getText();
			DireccionDTO direccion = new DireccionDTO(0,pais, provincia, localidad,codigoPostal, calle, altura, piso, depto);

			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String email = ventanaPersona.getTxtEmail().getText();
			String userLinkedin = ventanaPersona.getLinkedin().getText();
			String fecha_nacimiento = ventanaPersona.getTxtCumpleaños().getText();			
			
			this.agenda.agregarDireccion(direccion);
			DireccionDTO ultimaDir = this.agenda.ultimaDireccion();
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, email,userLinkedin, fecha_nacimiento,ultimaDir,ventanaPersona.getTipo());
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
			this.login.mostrarVentana();
		}
		
		private void refrescarTabla()
		{
			this.personasEnTabla = agenda.obtenerPersonas();
			this.vista.llenarTabla(this.personasEnTabla);
		}

		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
