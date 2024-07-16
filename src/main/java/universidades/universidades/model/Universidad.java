package universidades.universidades.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Universidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "universidad_codigo_universidad_seq")
    @SequenceGenerator(name = "universidad_codigo_universidad_seq", sequenceName = "universidad_codigo_universidad_seq", allocationSize = 1)
	private int codigo_universidad;
	private String nombre;
	private String direccion;
	private String telefono;
	public int getCodigo_universidad() {
		return codigo_universidad;
	}
	public void setCodigo_universidad(int codigo_universidad) {
		this.codigo_universidad = codigo_universidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Universidad [codigo_universidad=" + codigo_universidad + ", nombre=" + nombre + ", direccion="
				+ direccion + ", telefono=" + telefono + "]";
	}
	
	
	
	
	

}
