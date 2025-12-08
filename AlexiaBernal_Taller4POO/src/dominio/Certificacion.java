/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/

package dominio;

public class Certificacion 
{
	String id;
	String nombre;
	String descripcion;
	int creditosRequeridos;
	int añosValidez;
	public Certificacion(String id, String nombre, String descripcion, int creditosRequeridos, int añosValidez) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.creditosRequeridos = creditosRequeridos;
		this.añosValidez = añosValidez;
	}
	public String getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public int getCreditosRequeridos() {
		return creditosRequeridos;
	}
	public int getAñosValidez() {
		return añosValidez;
	}
	@Override
	public String toString() {
		return "Certificacion [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
