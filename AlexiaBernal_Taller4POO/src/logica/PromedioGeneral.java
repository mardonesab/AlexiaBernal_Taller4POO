/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package logica;

import java.util.ArrayList;

import dominio.NotaAsignatura;

public class PromedioGeneral implements PromedioStrategy 
{

	@Override
	public double calcular(ArrayList<NotaAsignatura> notas) {
		double suma = 0.0;
		int cantidad = 0;
		
		for (NotaAsignatura n : notas)
		{
			if (n.getCalificacion() > 0)
			{
				suma += n.getCalificacion();
				cantidad++;
			}
		}
		
		if (cantidad == 0)
		{
			return 0;
		}
		
		return suma / cantidad;
	}
	
}
