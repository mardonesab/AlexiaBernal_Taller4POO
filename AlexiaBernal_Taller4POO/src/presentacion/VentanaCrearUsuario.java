package presentacion;

import logica.CargaDatos;
import logica.UsuariosFactory;
import dominio.Usuario;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaCrearUsuario extends JFrame 
{
	JPanel panelContenido;
	
	public VentanaCrearUsuario()
	{
		setTitle("Crear Usuario");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		add(panelPrincipal);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));
		
		
		JButton botonCrearEstudiante = new JButton("Crear Estudiante");
		JButton botonCrearCoordinador = new JButton("Crear Coordinador");
		
		panelBotones.add(botonCrearEstudiante);
		panelBotones.add(botonCrearCoordinador);
		
		panelPrincipal.add(panelBotones, BorderLayout.NORTH);
		
		botonCrearEstudiante.addActionListener(e -> mostrarCrearEstudiante());
		botonCrearCoordinador.addActionListener(e -> mostrarCrearCoordinador());
		
		panelContenido = new JPanel();
		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.PAGE_AXIS));
		panelPrincipal.add(panelContenido, BorderLayout.CENTER);
		
		
	}
	
	void mostrarCrearEstudiante()
	{
		JTextField nombreUsuario = new JTextField();
		JTextField contraseña = new JTextField();
		JTextField rut = new JTextField();
		JTextField nombreCompleto = new JTextField();
		JTextField carrera = new JTextField();
		JTextField semestre = new JTextField();
		JTextField correo = new JTextField();
		
		panelContenido.add(new JLabel("Nombre de usuario:"));
		panelContenido.add(nombreUsuario);
		panelContenido.add(new JLabel("Contraseña:"));
		panelContenido.add(contraseña);
		panelContenido.add(new JLabel("Rut:"));
		panelContenido.add(rut);
		panelContenido.add(new JLabel("Nombre Completo:"));
		panelContenido.add(nombreCompleto);
		panelContenido.add(new JLabel("Carrera:"));
		panelContenido.add(carrera);
		panelContenido.add(new JLabel("Semestre:"));
		panelContenido.add(semestre);
		panelContenido.add(new JLabel("Correo:"));
		panelContenido.add(correo);
		
		JButton botonConfirmarEstudiante = new JButton("Confirmar Estudiante");
		panelContenido.add(botonConfirmarEstudiante);
		
		botonConfirmarEstudiante.addActionListener(e -> {
			
			Usuario nuevo = UsuariosFactory.crearEstudiante(nombreUsuario.getText(), contraseña.getText(), rut.getText(), nombreCompleto.getText(), carrera.getText(), Integer.parseInt(semestre.getText()), correo.getText());
			
			CargaDatos.getInstance().agregarUsuario(nuevo);
			
			JOptionPane.showMessageDialog(this, "Estudiante creado exitosamente");
			
		});
		
		
	}
	
	void mostrarCrearCoordinador()
	{
		JTextField nombreUsuario = new JTextField();
		JTextField contraseña = new JTextField();
		JTextField area = new JTextField();
		
		panelContenido.add(new JLabel("Nombre de usuario:"));
		panelContenido.add(nombreUsuario);
		panelContenido.add(new JLabel("Contraseña:"));
		panelContenido.add(contraseña);
		panelContenido.add(new JLabel("Área del Coordinador"));
		panelContenido.add(area);
		
		JButton botonConfirmarCoordinador = new JButton("Confirmar Coordinador");
		panelContenido.add(botonConfirmarCoordinador);
		
		botonConfirmarCoordinador.addActionListener(e -> {
			
			Usuario nuevo = UsuariosFactory.crearCoordinador(nombreUsuario.getText(), contraseña.getText(), area.getText());
			
			CargaDatos.getInstance().agregarUsuario(nuevo);
			
			JOptionPane.showMessageDialog(this, "Coordinador creado exitosamente");
			
		});
		
	}
	
	
	
}
