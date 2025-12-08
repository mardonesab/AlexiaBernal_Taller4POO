/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/

package dominio;

public class Curso 
{
	String nrc;
	String nombre;
	int semestre;
	int creditos;
	String area;
	String prerequisitos;
	public Curso(String nrc, String nombre, int semestre, int creditos, String area, String prerequisitos) {
		this.nrc = nrc;
		this.nombre = nombre;
		this.semestre = semestre;
		this.creditos = creditos;
		this.area = area;
		this.prerequisitos = prerequisitos;
	}
	public String getNrc() {
		return nrc;
	}
	public String getNombre() {
		return nombre;
	}
	public int getSemestre() {
		return semestre;
	}
	public int getCreditos() {
		return creditos;
	}
	public String getArea() {
		return area;
	}
	public String getPrerequisitos() {
		return prerequisitos;
	}
	@Override
	public String toString() {
		return "Curso [nrc=" + nrc + ", nombre=" + nombre + "]";
	}
	
	
	
}
