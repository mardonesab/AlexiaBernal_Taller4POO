/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package presentacion;

import dominio.Curso;
import dominio.NotaAsignatura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dominio.Estudiante;
import logica.CargaDatos;

public class VentanaMallaCurricularInteractiva  extends JFrame
{
	JPanel panelContenido;
	Estudiante estudianteActual;

	public VentanaMallaCurricularInteractiva(Estudiante est) {

	this.estudianteActual = est;

	setTitle("Malla Curricular Interactiva");
	setSize(800, 600);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	JPanel panelPrincipal = new JPanel(new BorderLayout());
	add(panelPrincipal);

	JPanel panelBotones = new JPanel();
	panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));

	JButton botonMostrar = new JButton("Mostrar Malla Interactiva");
	panelBotones.add(botonMostrar);

	panelPrincipal.add(panelBotones, BorderLayout.NORTH);

	// PANEL CENTRAL
	panelContenido = new JPanel();
	panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.PAGE_AXIS));
	panelPrincipal.add(panelContenido, BorderLayout.CENTER);

	botonMostrar.addActionListener(e -> mostrarMallaInteractiva());
	}
	
	public void mostrarMallaInteractiva()
	{
		panelContenido.removeAll();
		panelContenido.add(new JLabel("MALLA CURRICULAR INTERACTIVA"));
		panelContenido.add(new JLabel(" "));

		CargaDatos datos = CargaDatos.getInstance();

		for (int semestre = 1; semestre <= 8; semestre++)
		{
			panelContenido.add(new JLabel("SEMESTRE " + semestre));
			panelContenido.add(new JLabel("----------------------------------"));

			JPanel filaCursos = new JPanel(new FlowLayout(FlowLayout.LEFT));

			for (Curso c : datos.getCursos()) 
			{
				if (c.getSemestre() == semestre)
				{
					JButton botonCurso = new JButton(c.getNombre());
					botonCurso.setPreferredSize(new Dimension(200, 40));

					String estado = obtenerEstadoCurso(c.getNrc());

					switch (estado) 
					{
						case "Aprobado":
							botonCurso.setBackground(new Color(144, 238, 144)); // verde claro
						break;
						case "Cursando":
							botonCurso.setBackground(new Color(255, 255, 153)); // amarillo
						break;
						case "Reprobado":
							botonCurso.setBackground(new Color(255, 102, 102)); // rojo
						break;
						default:
							botonCurso.setBackground(Color.LIGHT_GRAY); // pendiente
						break;
					}
				
					botonCurso.addActionListener(ev -> mostrarInfoCurso(c, estado));
					
					filaCursos.add(botonCurso);
					
					
				}
			}
			
			panelContenido.add(filaCursos);
			panelContenido.add(new JLabel(" "));	
		}
		
		panelContenido.revalidate();
		panelContenido.repaint();
	}
	
	public String obtenerEstadoCurso(String nrc)
	{
		CargaDatos datos = CargaDatos.getInstance();

		for (NotaAsignatura n : datos.getNotas())
		{
			if (n.getRut().equals(estudianteActual.getRut()) && n.getCodigoCurso().equals(nrc)) 
			{
				double cal = n.getCalificacion();

				if (cal >= 4.0) return "Aprobado";
				if (cal == 0.0) return "Cursando";
				return "Reprobado";
			}
		}
		
		return "Pendiente";
	}
	
	
	private void mostrarInfoCurso(Curso c, String estado) 
	{
		String info =
				"Nombre: " + c.getNombre() + "\n" +
				"NRC: " + c.getNrc() + "\n" +
				"Área: " + c.getArea() + "\n" +
				"Créditos: " + c.getCreditos() + "\n" +
				"Semestre: " + c.getSemestre() + "\n" +
				"Prerequisito: " + (c.getPrerequisitos().equals("") ? "Ninguno" : c.getPrerequisitos()) + "\n" +
				"Estado del estudiante: " + estado;

				JOptionPane.showMessageDialog(this, info, "Información del Curso", JOptionPane.PLAIN_MESSAGE);
	}
}
