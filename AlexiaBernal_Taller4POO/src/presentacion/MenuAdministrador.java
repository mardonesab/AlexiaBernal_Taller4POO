package presentacion;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuAdministrador extends JFrame 
{
	public MenuAdministrador()
	{
		setTitle("Menu Administrador");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));
		
		JButton botonCrear = new JButton("Crear usuario");
		JButton botonModificar = new JButton("Modificar usuario");
		JButton botonEliminar = new JButton("Eliminar usuario");
		JButton botonRestablecer = new JButton("Restablecer contraseña");
		
		panelBotones.add(botonCrear);
		panelBotones.add(botonModificar);
		panelBotones.add(botonEliminar);
		panelBotones.add(botonRestablecer);
		
		add(panelBotones, BorderLayout.NORTH);
		
		botonCrear.addActionListener(e -> {});
		botonModificar.addActionListener(e -> {});
		botonEliminar.addActionListener(e -> {});
		botonRestablecer.addActionListener(e -> {});
		
		
		
	}
}
