package dominio;

public class RegistroCertificacion 
{
	String rut;
	String idCertificacion;
	String fechaRegistro;
	String estado;
	int progreso;
	public RegistroCertificacion(String rut, String idCertificacion, String fechaRegistro, String estado,
			int progreso) {
		super();
		this.rut = rut;
		this.idCertificacion = idCertificacion;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
		this.progreso = progreso;
	}
	public String getRut() {
		return rut;
	}
	public String getIdCertificacion() {
		return idCertificacion;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public String getEstado() {
		return estado;
	}
	public int getProgreso() {
		return progreso;
	}
	
	
}
