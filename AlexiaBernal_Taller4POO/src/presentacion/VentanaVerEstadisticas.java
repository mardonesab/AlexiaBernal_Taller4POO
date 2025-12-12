/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package presentacion;

import dominio.RegistroCertificacion;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.CargaDatos;

public class VentanaVerEstadisticas extends JFrame
{
	JPanel panelContenido;

	public VentanaVerEstadisticas() {

	setTitle("Estadísticas del Sistema");
	setSize(600, 400);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	JPanel panelPrincipal = new JPanel();
	panelPrincipal.setLayout(new BorderLayout());
	add(panelPrincipal);

	JPanel panelBotones = new JPanel();
	panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));

	JButton botonVer = new JButton("Mostrar Estadísticas");
	panelBotones.add(botonVer);

	panelPrincipal.add(panelBotones, BorderLayout.NORTH);

	panelContenido = new JPanel();
	panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.PAGE_AXIS));
	panelPrincipal.add(panelContenido, BorderLayout.CENTER);

	botonVer.addActionListener(e -> mostrarEstadisticas());
	}
	
	public void mostrarEstadisticas()
	{
		panelContenido.removeAll();

		CargaDatos datos = CargaDatos.getInstance();

		int totalEstudiantes = datos.getEstudiantes().size();
		int totalCertificaciones = datos.getCertificaciones().size();
		int totalRegistros = datos.getRegistros().size();

		int aprobados = 0;
		for (RegistroCertificacion r : datos.getRegistros()) {
		if (r.getEstado().equalsIgnoreCase("Completado")) {
		aprobados++;
		}
		}

		int cursando = totalRegistros - aprobados;


		panelContenido.add(new JLabel("ESTADÍSTICAS GENERALES:"));
		panelContenido.add(new JLabel("Total de estudiantes registrados: " + totalEstudiantes));
		panelContenido.add(new JLabel("Total de certificaciones: " + totalCertificaciones));
		panelContenido.add(new JLabel("Total de inscripciones en certificaciones: " + totalRegistros));
		panelContenido.add(new JLabel("Estudiantes con certificaciones aprobadas: " + aprobados));
		panelContenido.add(new JLabel("Estudiantes cursando certificaciones: " + cursando));

		panelContenido.revalidate();
		panelContenido.repaint();
	}
}
