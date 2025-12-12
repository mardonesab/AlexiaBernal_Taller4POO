/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package logica;

import dominio.NotaAsignatura;

public class AvanceEstudianteVisitor implements AvanceVisitor 
{
	int total = 0;
	int aprobados = 0;
	int reprobados = 0;
	int cursando = 0;
	
	@Override
	public void visit(NotaAsignatura nota) 
	{
		total++;
		
		double n = nota.getCalificacion();
		
		if (n == 0.0) 
		{
			cursando++;
		} else if (n >= 4.0)
		{
			aprobados++;
		} else
		{
			reprobados++;
		}
		
	}

	public int getTotal() {
		return total;
	}

	public int getAprobados() {
		return aprobados;
	}

	public int getReprobados() {
		return reprobados;
	}

	public int getCursando() {
		return cursando;
	}
	
	public int getAvancePorcentaje()
	{
		if (total == 0)
		{
			return 0;
		}
		return (aprobados * 100) / total;
	}
	
	
}
