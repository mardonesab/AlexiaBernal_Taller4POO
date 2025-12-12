/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package presentacion;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dominio.Estudiante;

public class MenuEstudiante extends JFrame
{
	
	Estudiante estudianteActual;
	
	public MenuEstudiante(Estudiante est)
	{
		this.estudianteActual = est;
		
		setTitle("Menu Estudiante");
		setSize(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));
		
		JButton botonPerfil = new JButton("Perfil");
		JButton botonMalla = new JButton("Malla Curricular");
		JButton botonCertificaciones = new JButton("Inscripción a certificaciones");
		JButton botonProgreso = new JButton("Seguimiento de Progreso");
		
		panelBotones.add(botonPerfil);
		panelBotones.add(botonMalla);
		panelBotones.add(botonCertificaciones);
		panelBotones.add(botonProgreso);
		
		add(panelBotones, BorderLayout.NORTH);
		
		JPanel panelContenido = new JPanel();
		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.PAGE_AXIS));
		add(panelContenido, BorderLayout.CENTER);
		
		botonPerfil.addActionListener(e -> mostrarPerfil(panelContenido));
		botonMalla.addActionListener(e -> new VentanaMallaCurricularInteractiva(estudianteActual).setVisible(true));
		botonCertificaciones.addActionListener(e -> {});
		botonProgreso.addActionListener(e -> new VentanaProgresoEstudiante(estudianteActual).setVisible(true));
	}
	
	public void mostrarPerfil(JPanel panelContenido) 
	{
		panelContenido.removeAll();

		panelContenido.add(new JLabel("PERFIL DEL ESTUDIANTE"));
		panelContenido.add(new JLabel("Nombre completo: " + estudianteActual.getNombreCompleto()));
		panelContenido.add(new JLabel("Rut: " + estudianteActual.getRut()));
		panelContenido.add(new JLabel("Carrera: " + estudianteActual.getCarrera()));
		panelContenido.add(new JLabel("Semestre: " + estudianteActual.getSemestre()));
		panelContenido.add(new JLabel("Correo: " + estudianteActual.getCorreo()));
		panelContenido.add(new JLabel("Username: " + estudianteActual.getNombre()));

		panelContenido.revalidate();
		panelContenido.repaint();
	}
}
