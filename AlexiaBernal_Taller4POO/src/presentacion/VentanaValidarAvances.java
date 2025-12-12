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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dominio.Estudiante;
import logica.AvanceEstudianteVisitor;
import logica.CargaDatos;

public class VentanaValidarAvances extends JFrame
{
	JPanel panelContenido;

	public VentanaValidarAvances() 
	{

	setTitle("Validar Avances del Estudiante");
	setSize(600, 450);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	JPanel panelPrincipal = new JPanel();
	panelPrincipal.setLayout(new BorderLayout());
	add(panelPrincipal);

	JPanel panelBotones = new JPanel();
	panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));

	JButton botonBuscar = new JButton("Buscar Estudiante");
	panelBotones.add(botonBuscar);

	panelPrincipal.add(panelBotones, BorderLayout.NORTH);

	panelContenido = new JPanel();
	panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.PAGE_AXIS));
	panelPrincipal.add(panelContenido, BorderLayout.CENTER);

	botonBuscar.addActionListener(e -> mostrarBusqueda());
	}
	
	public void mostrarBusqueda() 
	{
		panelContenido.removeAll();

		JTextField rut = new JTextField();

		panelContenido.add(new JLabel("Ingrese RUT del estudiante:"));
		panelContenido.add(rut);

		JButton botonBuscar = new JButton("Buscar");
		panelContenido.add(botonBuscar);

		botonBuscar.addActionListener(e -> {
			
			Estudiante estudiante = buscar(rut.getText());

			if (estudiante == null)
			{
				JOptionPane.showMessageDialog(this, "No existe un estudiante con ese RUT.");
				return;
			}
			
			mostrarAvance(estudiante);
		});
		
		panelContenido.revalidate();
		panelContenido.repaint();
	}
	
	public Estudiante buscar(String rut)
	{
		for (Estudiante e : CargaDatos.getInstance().getEstudiantes()) 
		{
			if (e.getRut().equals(rut)) 
			{
				return e;
			}
		}
		return null;
	}
	
	public void mostrarAvance(Estudiante estudiante) 
	{
		panelContenido.removeAll();

		AvanceEstudianteVisitor visitor = new AvanceEstudianteVisitor();

		estudiante.aceptarAvance(visitor, CargaDatos.getInstance().getNotas());
		
		panelContenido.add(new JLabel("AVANCE DEL ESTUDIANTE:"));
		panelContenido.add(new JLabel("Nombre: " + estudiante.getNombreCompleto()));
		panelContenido.add(new JLabel("Carrera: " + estudiante.getCarrera()));
		panelContenido.add(new JLabel("Semestre actual: " + estudiante.getSemestre()));
		panelContenido.add(new JLabel("Cursos totales: " + visitor.getTotal()));
		panelContenido.add(new JLabel("Aprobados: " + visitor.getAprobados()));
		panelContenido.add(new JLabel("Reprobados: " + visitor.getReprobados()));
		panelContenido.add(new JLabel("Cursando: " + visitor.getCursando()));

		panelContenido.add(new JLabel("Avance total: " + visitor.getAvancePorcentaje() + "%"));

		panelContenido.revalidate();
		panelContenido.repaint();
	}
	
}
