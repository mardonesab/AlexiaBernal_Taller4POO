package logica;

import java.util.ArrayList;

import dominio.Curso;

public class ListaCursos 
{
	CargaDatos datos = CargaDatos.getInstance();
	
	public ArrayList<Curso> getListaCursos()
	{
		return datos.getCursos();
	}
	
	public Curso buscarCurso(String nrc)
	{
		for (Curso c : datos.getCursos())
		{
			if (c.getNrc().endsWith(nrc))
			{
				return c;
			}
		}
		return null;
	}
}
