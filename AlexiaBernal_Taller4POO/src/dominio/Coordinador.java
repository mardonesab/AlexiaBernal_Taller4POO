package dominio;

public class Coordinador extends Usuario 
{
	String area;

	public Coordinador(String nombre, String contraseña, String area) {
		super(nombre, contraseña, "Coordinador");
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Coordinador [area=" + area + "]";
	}
	
	
	
	
	
	
	
	
	
}
