/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package logica;

import dominio.Administrador;
import dominio.Coordinador;
import dominio.Estudiante;

public class UsuariosFactory 
{
	public Administrador crearAdministrador(String nombre, String contraseña)
	{
		return new Administrador(nombre, contraseña);
	}
	
	public Coordinador crearCoordinador(String nombre, String contraseña, String area)
	{
		return new Coordinador(nombre, contraseña, area);
	}
	
	public Estudiante crearEstudiante(String nombre, String contraseña, String rut, String nombreCompleto, String carrera,
			int semestre, String correo)
	{
		return new Estudiante(nombre, contraseña, rut, nombreCompleto, carrera, semestre, correo);
	}
}
