/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package presentacion;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dominio.NotaAsignatura;
import logica.CargaDatos;

public class VentanaAsignaturasCriticas extends JFrame
{
	JPanel panelContenido;

	public VentanaAsignaturasCriticas() {

	setTitle("Asignaturas Críticas");
	setSize(600, 450);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	JPanel panelPrincipal = new JPanel();
	panelPrincipal.setLayout(new BorderLayout());
	add(panelPrincipal);

	JPanel panelBotones = new JPanel();
	panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));

	JButton botonAnalizar = new JButton("Analizar Asignaturas");
	panelBotones.add(botonAnalizar);

	panelPrincipal.add(panelBotones, BorderLayout.NORTH);

	panelContenido = new JPanel();
	panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.PAGE_AXIS));
	panelPrincipal.add(panelContenido, BorderLayout.CENTER);

	botonAnalizar.addActionListener(e -> analizarAsignaturas());
	}
	
	public void analizarAsignaturas()
	{
		panelContenido.removeAll();

		CargaDatos datos = CargaDatos.getInstance();

		ArrayList<String> codigosCursos = new ArrayList<>();

		for (NotaAsignatura n : datos.getNotas()) 
		{
			String codigo = n.getCodigoCurso();
			if (!codigosCursos.contains(codigo)) 
			{
				codigosCursos.add(codigo);
			}
		}
		
		panelContenido.add(new JLabel("Asignaturas críticas (más reprobados que aprobados):"));
		
		boolean algunaCritica = false;

		for (String codigo : codigosCursos)
		{
			int aprobados = 0;
			int reprobados = 0;

			for (NotaAsignatura n : datos.getNotas())
			{
				if (n.getCodigoCurso().equals(codigo))
				{
					if (n.getCalificacion() >= 4.0)
					{
						aprobados++;
					} else {
						reprobados++;
					}
				}
			}
			
			if (reprobados > aprobados) 
			{
				panelContenido.add(new JLabel(" - " + codigo + " | Reprobados: " + reprobados + " | Aprobados: " + aprobados));
				
				algunaCritica = true;
			}
		}
		
		if (!algunaCritica)
		{
			panelContenido.add(new JLabel("No hay asignaturas críticas en los datos."));
			
		}
		
		panelContenido.revalidate();
		panelContenido.repaint();
	}
}
	












