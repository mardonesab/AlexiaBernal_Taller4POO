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
