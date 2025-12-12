/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/

package dominio;

public abstract class Usuario 
{
	String nombre;
	String contraseña;
	String rol;
	public Usuario(String nombre, String contraseña, String rol) 
	{
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.rol = rol;
	}
	public String getNombre() {
		return nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public String getRol() {
		return rol;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", rol=" + rol + "]";
	}
	
	
	public abstract void mostrarMenu();
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
	
}
