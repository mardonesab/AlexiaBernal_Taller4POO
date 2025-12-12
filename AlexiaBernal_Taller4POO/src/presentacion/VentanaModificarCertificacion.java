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

import dominio.Certificacion;
import logica.CargaDatos;

public class VentanaModificarCertificacion extends JFrame
{
	JPanel panelContenido;

	public VentanaModificarCertificacion() {

	setTitle("Modificar Certificación");
	setSize(600, 450);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	JPanel panelPrincipal = new JPanel();
	panelPrincipal.setLayout(new BorderLayout());
	add(panelPrincipal);

	JPanel panelBotones = new JPanel();
	panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));

	JButton botonBuscar = new JButton("Buscar Certificación");
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

		 JTextField codigoCert = new JTextField();

		 panelContenido.add(new JLabel("Ingrese el código de la certificación:"));
		 panelContenido.add(codigoCert);

		 JButton botonBuscar = new JButton("Buscar");
		 panelContenido.add(botonBuscar);
		 
		 botonBuscar.addActionListener(e -> {
			 
			 String codigo = codigoCert.getText();
			 Certificacion c = buscarCertificacion(codigo);

			 if (c == null) {
			 JOptionPane.showMessageDialog(this, "No existe una certificación con ese código.");
			 return;
			 }

			 mostrarModificacion(c);
			 
		 });
		 
		 panelContenido.revalidate();
		 panelContenido.repaint();

	 }
	 
	 public Certificacion buscarCertificacion(String codigo) 
	 {
		 for (Certificacion c : CargaDatos.getInstance().getCertificaciones()) 
		 {
			 if (c.getId().equals(codigo)) 
			 { 
			 	return c;
			 }
		 }
		 return null;
	 }
	 
	 private void mostrarModificacion(Certificacion c)
	 {
		 panelContenido.removeAll();
		 
		 JTextField nombre = new JTextField(c.getNombre());
		 JTextField descripcion = new JTextField(c.getDescripcion());
		 JTextField creditos = new JTextField(String.valueOf(c.getCreditosRequeridos()));
		 JTextField duracion = new JTextField(String.valueOf(c.getAñosValidez()));
		 
		 panelContenido.add(new JLabel("Nombre:"));
		 panelContenido.add(nombre);
		 panelContenido.add(new JLabel("Descripción:"));
		 panelContenido.add(descripcion);
		 panelContenido.add(new JLabel("Créditos necesarios:"));
		 panelContenido.add(creditos);
		 panelContenido.add(new JLabel("Años de Validez:"));
		 panelContenido.add(duracion);

		 JButton botonGuardar = new JButton("Guardar Cambios");
		 JButton botonCancelar = new JButton("Cancelar");

		 panelContenido.add(botonGuardar);
		 panelContenido.add(botonCancelar);
		 
		 botonGuardar.addActionListener(e -> {
			 
			 c.setNombre(nombre.getText());
			 c.setDescripcion(descripcion.getText());
			 c.setCreditosRequeridos(Integer.parseInt(creditos.getText()));
			 c.setAñosValidez(Integer.parseInt(duracion.getText()));

			 JOptionPane.showMessageDialog(this, "Certificación modificada correctamente.");
			 dispose();
			 
		 });
		 
		 botonCancelar.addActionListener(e -> dispose());

		 panelContenido.revalidate();
		 panelContenido.repaint();
	 }
	
}	
	
	
	
	
