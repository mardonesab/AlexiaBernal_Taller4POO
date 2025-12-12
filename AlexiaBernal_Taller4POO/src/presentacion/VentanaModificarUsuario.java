/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package presentacion;

import dominio.Usuario;
import dominio.Estudiante;
import dominio.Coordinador;
import logica.CargaDatos;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaModificarUsuario extends JFrame 
{
	JPanel panelContenido;
	
	public VentanaModificarUsuario() 
	{
		setTitle("Modificar Usuario");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		add(panelPrincipal);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));

		JButton botonBuscar = new JButton("Buscar Usuario");
		panelBotones.add(botonBuscar);
		
		panelPrincipal.add(panelBotones, BorderLayout.NORTH);
		
		panelContenido = new JPanel();
		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.PAGE_AXIS));
		panelPrincipal.add(panelContenido, BorderLayout.CENTER);
		
		botonBuscar.addActionListener(e -> mostrarBusqueda());
	
	}
	
	void mostrarBusqueda()
		{
			panelContenido.removeAll();

		
			JTextField nombreUsuario = new JTextField();
			
			panelContenido.add(new JLabel("Ingrese nombre del usuario que desea modificar:"));
			panelContenido.add(nombreUsuario);
			
			JButton botonBuscar = new JButton("Buscar");
			panelContenido.add(botonBuscar);
			
			botonBuscar.addActionListener(e -> {
				
				String nombre = nombreUsuario.getText();
				Usuario u = buscarUsuario(nombre);
				
				if (u == null)
				{
					JOptionPane.showMessageDialog(this, "No existe un usuario con ese nombre.");
					return;
				}
				
				mostrarRealizarModificacion(u);
	
			});
			
			panelContenido.revalidate();
			panelContenido.repaint();
		}
	
	public Usuario buscarUsuario(String nombre)
	{
		for (Usuario u : CargaDatos.getInstance().getUsuarios())
		{
			if (u.getNombre().equals(nombre))
			{
				return u;
			}
		}
		return null;
	}
	
	public void mostrarRealizarModificacion(Usuario u)
	{
		panelContenido.removeAll();
		
		JTextField nombreUsuario = new JTextField(u.getNombre());
		JTextField contraseña = new JTextField(u.getContraseña());
		
		panelContenido.add(new JLabel("Nombre de usuario:"));
		panelContenido.add(nombreUsuario);
		panelContenido.add(new JLabel("Contraseña:"));
		panelContenido.add(contraseña);
		
		JTextField dato1 = new JTextField();
		JTextField dato2 = new JTextField();
		JTextField dato3 = new JTextField();
		JTextField dato4 = new JTextField();
		JTextField area = new JTextField();
		
		if (u instanceof Estudiante e)
		{
 
			
			panelContenido.add(new JLabel("RUT:"));
			panelContenido.add(dato1);
			panelContenido.add(new JLabel("Nombre completo:"));
			panelContenido.add(dato2);
			panelContenido.add(new JLabel("Carrera:"));
			panelContenido.add(dato3);
			panelContenido.add(new JLabel("Semestre:"));
			panelContenido.add(dato4);
		}
		
		
		
		if (u instanceof Coordinador c)
		{
			
			panelContenido.add(new JLabel("Área del Coordinador:"));
			panelContenido.add(area);
		}
		
		JButton botonGuardar = new JButton("Guardar Cambios");
		panelContenido.add(botonGuardar);
		
		JButton botonCancelar = new JButton("Cancelar");
		panelContenido.add(botonCancelar);
		
		botonGuardar.addActionListener(e -> {
			
			u.setNombre(nombreUsuario.getText());
			u.setContraseña(contraseña.getText());
			
			if (u instanceof Estudiante estudiante)
			{
				estudiante.setRut(dato1.getText());
				estudiante.setNombreCompleto(dato2.getText());
				estudiante.setCarrera(dato3.getText());
				estudiante.setSemestre(Integer.parseInt(dato4.getText()));
			}
			
			if (u instanceof Coordinador coordinador)
			{
				coordinador.setArea(area.getText());
			}
			
			JOptionPane.showMessageDialog(this, "Usuario modificado correctamente.");
			
		});
		
		botonCancelar.addActionListener(e -> dispose());
		
		panelContenido.revalidate();
		panelContenido.repaint();
		
	}
	
	
	
}
