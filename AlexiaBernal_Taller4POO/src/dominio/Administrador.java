/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/

package dominio;

public class Administrador extends Usuario
{

	public Administrador(String nombre, String contraseña) {
		super(nombre, contraseña, "Administrador");
	}

	@Override
	public void mostrarMenu() {
		System.out.println("Menú del Administrador");
		
	}
	
}
