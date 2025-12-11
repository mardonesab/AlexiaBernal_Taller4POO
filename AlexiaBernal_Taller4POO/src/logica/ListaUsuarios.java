/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package logica;

import java.util.ArrayList;


import dominio.Usuario;

public class ListaUsuarios 
{
	CargaDatos datos = CargaDatos.getInstance();
	
	public ArrayList<Usuario> getListaUsuarios()
	{
		return datos.getUsuarios();
	}
	
	public Usuario buscarUsuario(String nombre, String contraseña)
	{
		for (Usuario u : datos.getUsuarios())
		{
			if (u.getNombre().equals(nombre) && u.getContraseña().equals(contraseña))
			{
				return u;
			}
		}
		
		return null;
	}
}
