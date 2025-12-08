/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/

package dominio;

public class NotaAsignatura 
{
	String rut;
	String codigoCurso;
	double calificacion;
	String estado;
	String semestre;
	public NotaAsignatura(String rut, String codigoCurso, double calificacion, String estado, String semestre) {
		super();
		this.rut = rut;
		this.codigoCurso = codigoCurso;
		this.calificacion = calificacion;
		this.estado = estado;
		this.semestre = semestre;
	}
	public String getRut() {
		return rut;
	}
	public String getCodigoCurso() {
		return codigoCurso;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public String getEstado() {
		return estado;
	}
	public String getSemestre() {
		return semestre;
	}
	
	
}
