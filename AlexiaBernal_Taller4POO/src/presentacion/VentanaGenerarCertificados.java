package presentacion;



import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dominio.Certificacion;
import dominio.Estudiante;
import dominio.RegistroCertificacion;
import logica.CargaDatos;

public class VentanaGenerarCertificados  extends JFrame 
{
	JPanel panelContenido;

	public VentanaGenerarCertificados() 
	{

	setTitle("Generar Certificados");
	setSize(600, 450);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	JPanel panelPrincipal = new JPanel();
	panelPrincipal.setLayout(new BorderLayout());
	add(panelPrincipal);

	JPanel panelBotones = new JPanel();
	panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));

	JButton btnSeleccionar = new JButton("Seleccionar Certificación");
	panelBotones.add(btnSeleccionar);

	panelPrincipal.add(panelBotones, BorderLayout.NORTH);

	panelContenido = new JPanel();
	panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.PAGE_AXIS));
	panelPrincipal.add(panelContenido, BorderLayout.CENTER);

	btnSeleccionar.addActionListener(e -> mostrarSeleccion());
	}
	
	public void mostrarSeleccion()
	{
		panelContenido.removeAll();

		JComboBox<String> combo = new JComboBox<>();

		for (Certificacion c : CargaDatos.getInstance().getCertificaciones()) 
		{
		combo.addItem(c.getId());
		}
		
		panelContenido.add(new JLabel("Seleccione certificación:"));
		panelContenido.add(combo);

		JButton botonGenerar = new JButton("Generar Certificados");
		panelContenido.add(botonGenerar);
		
		botonGenerar.addActionListener(e -> generarCertificados((String) combo.getSelectedItem()));
		
		panelContenido.revalidate();
		panelContenido.repaint();
				
	}
	
	public void generarCertificados(String codigoCertificacion)
	{
		panelContenido.removeAll();

		CargaDatos datos = CargaDatos.getInstance();

		panelContenido.add(new JLabel("Estudiantes que completaron la certificación " + codigoCertificacion + ":"));

		boolean encontrado = false;
		
		for (RegistroCertificacion r : datos.getRegistros()) 
		{
			if (r.getIdCertificacion().equals(codigoCertificacion) && r.getEstado().equalsIgnoreCase("Completado"
					+ ""))
			{
				Estudiante estudiante = buscarEstudiantePorRut(r.getRut());
				
				if (estudiante != null) 
				{
					panelContenido.add(new JLabel(" - " + estudiante.getNombreCompleto() + " (" + estudiante.getRut() + ")"));
					encontrado = true;
				}
			}
		}
		
		if (!encontrado) 
		{
			panelContenido.add(new JLabel("Ningún estudiante ha completado esta certificación."));
		}
		
		panelContenido.revalidate();
		panelContenido.repaint();
	}
	
	public Estudiante buscarEstudiantePorRut(String rut)
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
	
	
}


























