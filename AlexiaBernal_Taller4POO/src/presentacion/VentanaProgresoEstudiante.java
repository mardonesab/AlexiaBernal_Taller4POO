/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package presentacion;

import dominio.NotaAsignatura;
import logica.CargaDatos;
import logica.PromedioGeneral;
import logica.PromedioPorSemestre;

import logica.PromedioStrategy;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dominio.Estudiante;

public class VentanaProgresoEstudiante extends JFrame 
{
	JPanel panelContenido;
	Estudiante estudianteActual;

	public VentanaProgresoEstudiante(Estudiante est) {

	this.estudianteActual = est;

	setTitle("Seguimiento de Progreso");
	setSize(600, 450);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	JPanel panelPrincipal = new JPanel(new BorderLayout());
	add(panelPrincipal);

	JPanel panelBotones = new JPanel();
	panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));

	JButton botonGeneral = new JButton("Promedio General");
	JButton botonSemestral = new JButton("Promedio por Semestre");
	panelBotones.add(botonGeneral);
	panelBotones.add(botonSemestral);

	panelPrincipal.add(panelBotones, BorderLayout.NORTH);

	panelContenido = new JPanel();
	panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.PAGE_AXIS));
	panelPrincipal.add(panelContenido, BorderLayout.CENTER);

	botonGeneral.addActionListener(e -> mostrarPromedioGeneral());
	botonSemestral.addActionListener(e -> mostrarPromedioPorSemestre());
	}
	
	public ArrayList<NotaAsignatura> obtenerNotasEstudiante()
	{
		ArrayList<NotaAsignatura> lista = new ArrayList<>();
		
		for (NotaAsignatura n : CargaDatos.getInstance().getNotas())
		{
			if (n.getRut().equals(estudianteActual.getRut())) 
			{
				lista.add(n);
			}
		}
		
		return lista;

	}
	
	public void mostrarPromedioGeneral()
	{
		panelContenido.removeAll();

		PromedioStrategy estrategia = new PromedioGeneral();
		double promedio = estrategia.calcular(obtenerNotasEstudiante());

		panelContenido.add(new JLabel("Promedio general del estudiante: " + promedio));

		panelContenido.revalidate();
		panelContenido.repaint();
	}
	
	public void mostrarPromedioPorSemestre()
	{
		panelContenido.removeAll();

		String semestre = JOptionPane.showInputDialog("Ingrese el semestre (ej: 2023-2):");

		if (semestre == null || semestre.trim().isEmpty()) return;

		PromedioStrategy estrategia = new PromedioPorSemestre(semestre);
		double promedio = estrategia.calcular(obtenerNotasEstudiante());

		panelContenido.add(new JLabel("Promedio del semestre " + semestre + ": " + promedio));

		panelContenido.revalidate();
		panelContenido.repaint();
	}

}
