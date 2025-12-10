package logica;

import java.util.ArrayList;

import dominio.Estudiante;

public class ListaEstudiantes 
{
	CargaDatos datos = CargaDatos.getInstance();
	
	public ArrayList<Estudiante> getListaEstudiantes()
	{
		return datos.getEstudiantes();
	}
	
	public Estudiante buscarEstudiante(String rut)
	{
		for (Estudiante e : datos.getEstudiantes())
		{
			if (e.getRut().equals(rut))
			{
				return e;
			}
		}
		return null;
	}
}
