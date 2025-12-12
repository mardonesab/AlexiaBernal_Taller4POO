/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package logica;

import java.util.ArrayList;

import dominio.NotaAsignatura;

public class PromedioPorSemestre implements PromedioStrategy
{
	private String semestreObjetivo;

	public PromedioPorSemestre(String semestre) 
	{
		this.semestreObjetivo = semestre;
	}

	@Override
	public double calcular(ArrayList<NotaAsignatura> notas) {
		
		double suma = 0;
		int cantidad = 0;

		for (NotaAsignatura n : notas) 
		{
			if (n.getSemestre().equals(semestreObjetivo) && n.getCalificacion() > 0) 
			{
				suma += n.getCalificacion();
				cantidad++;
			}
		}

		if (cantidad == 0) return 0;

		return suma / cantidad;
	}
	
	
}
