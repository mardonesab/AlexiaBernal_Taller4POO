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
import logica.CargaDatos;

public class VentanaPerfilEstudiante extends JFrame
{
	JPanel panelContenido;

	public VentanaPerfilEstudiante() {

	setTitle("Perfil del Estudiante");
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

		JTextField rutBusc = new JTextField();

		panelContenido.add(new JLabel("Ingrese RUT del estudiante:"));
		panelContenido.add(rutBusc);

		JButton botonBuscar = new JButton("Buscar");
		panelContenido.add(botonBuscar);

		botonBuscar.addActionListener(e -> {
			
			String rut = rutBusc.getText();
			Estudiante estudiante = buscarEstudiante(rut);
			
			if (estudiante == null) 
			{
				JOptionPane.showMessageDialog(this, "No existe un estudiante con ese RUT.");
				return;
			}
			
			mostrarPerfil(estudiante);
		});
		
		panelContenido.revalidate();
		panelContenido.repaint();
	}
	
	public Estudiante buscarEstudiante(String rut)
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
	
	public void mostrarPerfil(Estudiante e)
	{
		panelContenido.removeAll();
		
		panelContenido.add(new JLabel("PERFIL DEL ESTUDIANTE:"));
		panelContenido.add(new JLabel("RUT: " + e.getRut()));
		panelContenido.add(new JLabel("Nombre completo: " + e.getNombreCompleto()));
		panelContenido.add(new JLabel("Carrera: " + e.getCarrera()));
		panelContenido.add(new JLabel("Semestre actual: " + e.getSemestre()));
		panelContenido.add(new JLabel("Correo: " + e.getCorreo()));
		panelContenido.add(new JLabel("Nombre de usuario: " + e.getNombre()));

		panelContenido.revalidate();
		panelContenido.repaint();
	}
	
}



















