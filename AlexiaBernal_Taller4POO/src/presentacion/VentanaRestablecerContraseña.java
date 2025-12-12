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

import dominio.Usuario;
import logica.CargaDatos;

public class VentanaRestablecerContraseña extends JFrame 
{
	JPanel panelContenido;
	
	public VentanaRestablecerContraseña() 
	{
		setTitle("Restablecer Contraseña");
		setSize(600, 350);
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
	
	public void mostrarBusqueda()
	{
		panelContenido.removeAll();
		
		JTextField nombreUsuario = new JTextField();
		
		panelContenido.add(new JLabel("Ingrese nombre de usuario:"));
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

			mostrarRestablecer(u);
			
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
	
	public void mostrarRestablecer(Usuario u)
	{
		panelContenido.removeAll();
		
		panelContenido.add(new JLabel("Restablecer contraseña para: " + u.getNombre()));
		
		JTextField contraseñaNueva = new JTextField();
		panelContenido.add(new JLabel("Nueva contraseña:"));
		panelContenido.add(contraseñaNueva);
		
		JButton botonGuardar = new JButton("Guardar");
		JButton botonCancelar = new JButton("Cancelar");

		panelContenido.add(botonGuardar);
		panelContenido.add(botonCancelar);
		
		botonGuardar.addActionListener(e -> {
			
			u.setContraseña(contraseñaNueva.getText());
			
			JOptionPane.showMessageDialog(this, "Contraseña actualizada correctamente.");
			dispose();
		
		});
		
		botonCancelar.addActionListener(ev -> dispose());
		
		panelContenido.revalidate();
		panelContenido.repaint();
		
	}
}
























