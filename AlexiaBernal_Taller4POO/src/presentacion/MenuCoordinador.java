package presentacion;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuCoordinador extends JFrame 
{
	public MenuCoordinador()
	{
		setTitle("Menu Coordinador");
		setSize(1250, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));
		
		JButton botonModificarCert = new JButton("Modificar linea de certificación");
		JButton botonGenerarCert = new JButton("Generar Certificados");
		JButton botonEstadisticas = new JButton("Mostrar Estadísitcas");
		JButton botonAsignaturasCriticas = new JButton("Análisis de asignaturas críticas");
		JButton botonPerfilesEstudiantes = new JButton("Consultar perfiles de Estudiantes");
		JButton botonAvancesAcademicos = new JButton("Revisar y validar avances académicos");
		
		panelBotones.add(botonModificarCert);
		panelBotones.add(botonGenerarCert);
		panelBotones.add(botonEstadisticas);
		panelBotones.add(botonAsignaturasCriticas);
		panelBotones.add(botonPerfilesEstudiantes);
		panelBotones.add(botonAvancesAcademicos);
		
		add(panelBotones, BorderLayout.NORTH);
		
		botonModificarCert.addActionListener(e -> new VentanaModificarCertificacion().setVisible(true));
		botonGenerarCert.addActionListener(e -> new VentanaGenerarCertificados().setVisible(true));
		botonEstadisticas.addActionListener(e -> new VentanaVerEstadisticas().setVisible(true));
		botonAsignaturasCriticas.addActionListener(e -> new VentanaAsignaturasCriticas().setVisible(true));
		botonPerfilesEstudiantes.addActionListener(e -> new VentanaPerfilEstudiante().setVisible(true));
		botonAvancesAcademicos.addActionListener(e -> new VentanaValidarAvances().setVisible(true));
		
		
	}
}
