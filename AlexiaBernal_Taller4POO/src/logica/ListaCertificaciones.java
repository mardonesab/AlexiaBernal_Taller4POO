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
