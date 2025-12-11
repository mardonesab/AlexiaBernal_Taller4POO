package presentacion;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaCrearUsuario extends JFrame 
{
	JPanel panelContenido;
	
	public VentanaCrearUsuario()
	{
		setTitle("Crear Usuario");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		add(panelPrincipal);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));
		
		
		JButton botonCrearEstudiante = new JButton("Crear Estudiante");
		JButton botonCrearCoordinador = new JButton("Crear Coordinador");
		
		panelBotones.add(botonCrearEstudiante);
		panelBotones.add(botonCrearCoordinador);
		
		panelPrincipal.add(panelBotones, BorderLayout.NORTH);
		
		botonCrearEstudiante.addActionListener(e -> {});
		botonCrearCoordinador.addActionListener(e -> {});
		
		
		
	}
	
	
	
}
