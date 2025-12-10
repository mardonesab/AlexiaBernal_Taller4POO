package presentacion;

import javax.swing.JOptionPane;

import dominio.Usuario;
import logica.CargaDatos;
import logica.ListaUsuarios;

public class App {

	public static void main(String[] args) 
	{
		CargaDatos datos = CargaDatos.getInstance();
		datos.cargarUsuarios();
		datos.cargarEstudiantes();
		datos.cargarCursos();
		datos.cargarCertificaciones();
		datos.cargarRegistros();
		datos.cargarNotas();
		
		ListaUsuarios listaUsuarios = new ListaUsuarios(); 
		
		boolean acceso = false;
		Usuario usuario = null;
		
		while (!acceso)
		{
			String nombreUsuario = JOptionPane.showInputDialog("Ingrese usuario:");
			String contraseña = JOptionPane.showInputDialog("Ingrese contraseña:");
			
			usuario = listaUsuarios.buscarUsuario(nombreUsuario, contraseña);
			
			if (usuario != null)
			{
				acceso = true;
			} else 
			{
				JOptionPane.showInputDialog(null, "Usuario o contraseña incorrecta");
			}
		}
		
		JOptionPane.showInputDialog(null, "Bienvenido(a) " + usuario.getNombre());
		
		if (usuario.getRol().equals("Administrador"))
		{
			new MenuAdministrador().setVisible(true);
		} else if (usuario.getRol().equals("Coordinador"))
		{
			new MenuCoordinador().setVisible(true);
		} else
		{
			new MenuEstudiante().setVisible(true);
		}

	}

}
