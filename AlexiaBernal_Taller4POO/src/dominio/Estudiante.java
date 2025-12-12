/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/

package dominio;

import java.util.ArrayList;

import logica.AvanceVisitor;

public class Estudiante extends Usuario 
{
	String rut;
	String nombreCompleto;
	String carrera;
	int semestre;
	String correo;
	public Estudiante(String nombre, String contraseña, String rut, String nombreCompleto, String carrera,
			int semestre, String correo) {
		super(nombre, contraseña, "Estudiante");
		this.rut = rut;
		this.nombreCompleto = nombreCompleto;
		this.carrera = carrera;
		this.semestre = semestre;
		this.correo = correo;
	}
	public String getRut() {
		return rut;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public String getCarrera() {
		return carrera;
	}
	public int getSemestre() {
		return semestre;
	}
	public String getCorreo() {
		return correo;
	}
	@Override
	public String toString() {
		return "Estudiante [rut=" + rut + ", nombreCompleto=" + nombreCompleto + "]";
	}
	@Override
	public void mostrarMenu() {
		System.out.println("Menú del Estudiante");
		
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public void aceptarAvance(AvanceVisitor visitor, ArrayList<NotaAsignatura> notas)
	{
		for (NotaAsignatura n : notas)
		{
			if (n.getRut().equals(this.getRut()))
			{
				visitor.visit(n);
			}
		}
	}
	
	

	
	
	
	
	
}
