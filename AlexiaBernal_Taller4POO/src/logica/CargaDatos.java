/*
 * Alexia Antonia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
*/
package logica;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import dominio.Administrador;
import dominio.Certificacion;
import dominio.Coordinador;
import dominio.Curso;
import dominio.Estudiante;
import dominio.NotaAsignatura;
import dominio.RegistroCertificacion;
import dominio.Usuario;

public class CargaDatos 
{
	private static CargaDatos instance;
	
	ArrayList<Usuario> usuarios = new ArrayList<>();
	ArrayList<Estudiante> estudiantes  = new ArrayList<>();
	ArrayList<Curso> cursos  = new ArrayList<>();
	ArrayList<Certificacion> certificaciones = new ArrayList<>();
	ArrayList<RegistroCertificacion> registros = new ArrayList<>();
	ArrayList<NotaAsignatura> notas = new ArrayList<>();
	
	private CargaDatos() {}
	
	public static CargaDatos getInstance()
	{
		if (instance == null)
		{
			instance = new CargaDatos();
		}
		return instance;
	}
	
	
	public void cargarUsuarios()
	{
		try 
		{
			Scanner scanner  = new Scanner(new File("usuarios.txt"));
			while (scanner.hasNextLine())
			{
				String linea = scanner.nextLine();
				String[] partes = linea.split(";");
				if (partes[2].equals("Administrador"))
				{
					usuarios.add(new Administrador(partes[0], partes[1]));
				} else if (partes[2].equals("Coordinador"))
				{
					usuarios.add(new Coordinador(partes[2], partes[1], partes[3]));
				}
			}			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarEstudiantes() 
	{
		try {
			Scanner scanner = new Scanner(new File("estudiantes.txt"));
			while (scanner.hasNextLine())
			{
				String linea = scanner.nextLine();
				String[] partes = linea.split(";");
			
				Estudiante estudiante = new Estudiante(partes[4], partes[5], partes[0], partes[1], partes[2], Integer.parseInt(partes[3]), partes[4]);
			
				estudiantes.add(estudiante);
				usuarios.add(estudiante);
			}
			scanner.close();
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void cargarCertificaciones()
	{
		try {
			Scanner scanner = new Scanner(new File("certificaciones.txt"));
			while (scanner.hasNextLine())
			{
				String linea = scanner.nextLine();
				String[] partes = linea.split(";");
				
				Certificacion certificacion = new Certificacion(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]));
				certificaciones.add(certificacion);						
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

	public void cargarRegistros()
	{
		try {
			Scanner scanner = new Scanner(new File("registros.txt"));
			while (scanner.hasNextLine())
			{
				String linea = scanner.nextLine();
				String [] partes = linea.split(";");
				
				RegistroCertificacion registro = new RegistroCertificacion(partes[0], partes[1], partes[2], partes[3], Integer.parseInt(partes[4]));
				registros.add(registro);				
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	public void cargarNotas()
	{
		try {
			Scanner scanner = new Scanner(new File("notas.txt"));
			while (scanner.hasNextLine())
			{
				String linea = scanner.nextLine();
				String [] partes = linea.split(";");
				
				NotaAsignatura nota = new NotaAsignatura(partes[0], partes[1], Double.parseDouble(partes[2]), partes[3], partes[4]);
				notas.add(nota);
			}
			scanner.close();
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public ArrayList<Certificacion> getCertificaciones() {
		return certificaciones;
	}

	public void setCertificaciones(ArrayList<Certificacion> certificaciones) {
		this.certificaciones = certificaciones;
	}

	public ArrayList<RegistroCertificacion> getRegistros() {
		return registros;
	}

	public void setRegistros(ArrayList<RegistroCertificacion> registros) {
		this.registros = registros;
	}

	public ArrayList<NotaAsignatura> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<NotaAsignatura> notas) {
		this.notas = notas;
	}
	
	
	
}


