package main;

import modelo.Agenda;
import org.apache.log4j.BasicConfigurator;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import presentacion.vista.Vista;


public class Main 
{

	public static void main(String[] args) 
	{
		BasicConfigurator.configure();
		Vista vista = new Vista();
		Agenda modelo = new Agenda(new DAOSQLFactory());
		Controlador controlador = new Controlador(vista, modelo);
		controlador.inicializar();
	}
}
