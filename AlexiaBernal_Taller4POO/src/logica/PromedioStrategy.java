/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package logica;

import java.util.ArrayList;

import dominio.NotaAsignatura;

public interface PromedioStrategy 
{
	double calcular(ArrayList<NotaAsignatura> notasdeEstudiante);
}
