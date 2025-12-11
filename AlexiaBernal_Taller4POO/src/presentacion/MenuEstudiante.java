package presentacion;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuEstudiante extends JFrame
{
	public MenuEstudiante()
	{
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
		
		botonPerfil.addActionListener(e -> {});
		botonMalla.addActionListener(e -> {});
		botonCertificaciones.addActionListener(e -> {});
		botonProgreso.addActionListener(e -> {});
	}
}
