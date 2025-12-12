package presentacion;

import dominio.Usuario;
import logica.CargaDatos;
import dominio.Estudiante;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaEliminarUsuario extends JFrame 
{
	JPanel panelContenido;

	public VentanaEliminarUsuario()
	{
		setTitle("Eliminar Usuario");
		setSize(600, 400);
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
		
		panelContenido.add(new JLabel("Ingrese nombre de usuario que desea eliminar:"));
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
			
			confirmarEliminacion(u);
			
		});
		
		panelContenido.revalidate();
		panelContenido.repaint();
	}
	
	public Usuario buscarUsuario(String nombre) 
	{
		for (Usuario u : CargaDatos.getInstance().getUsuarios()) {
		if (u.getNombre().equals(nombre)) {
		return u;
		}
		}
		return null;
	}
	
	public void confirmarEliminacion(Usuario u)
	{
		panelContenido.removeAll();
		
		panelContenido.add(new JLabel("¿Seguro que desea eliminar este usuario?"));
		panelContenido.add(new JLabel("Nombre de usuario: " + u.getNombre()));
		panelContenido.add(new JLabel("Rol: " + u.getRol()));
		
		JButton botonEliminar = new JButton("Eliminar Usuario");
		JButton botonCancelar = new JButton("Cancelar");
		
		panelContenido.add(botonEliminar);
		panelContenido.add(botonEliminar);
		
		botonEliminar.addActionListener(e -> {
			
			CargaDatos datos = CargaDatos.getInstance();
			datos.getUsuarios().remove(u);
			
			if (u instanceof Estudiante estudiante) 
			{
				datos.getEstudiantes().remove(estudiante);
			}
			
			JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
			dispose();
			
			
		});
		
		botonCancelar.addActionListener(ev -> dispose());
		
		panelContenido.revalidate();
		panelContenido.repaint();
	}
		
}



















