/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package logica;

import java.util.ArrayList;

import dominio.RegistroCertificacion;

public class ListaRegistros 
{
	CargaDatos datos = CargaDatos.getInstance();
	
	public ArrayList<RegistroCertificacion> getListaRegistos()
	{
		return datos.getRegistros();
	}
	
	public ArrayList<RegistroCertificacion> buscarRegistro(String rut)
	{
		ArrayList<RegistroCertificacion> lista = new ArrayList<>();
		
		for (RegistroCertificacion r : datos.getRegistros())
		{
			if (r.getRut().equals(rut))
			{
				lista.add(r);
			}
		}
		return lista;
	}
}
