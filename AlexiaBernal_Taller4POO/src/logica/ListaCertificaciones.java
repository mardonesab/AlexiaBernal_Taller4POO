/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package logica;
import java.util.ArrayList;

import dominio.Certificacion;

public class ListaCertificaciones 
{
	CargaDatos datos = CargaDatos.getInstance();
	
	public ArrayList<Certificacion> getListaCertificaciones()
	{
		return datos.getCertificaciones();
	}
	
	public Certificacion buscarCertificacion(String id)
	{
		for (Certificacion c : datos.getCertificaciones())
		{
			if (c.getId().equals(id))
			{
				return c;
			}
		}
		return null;
	}
}
