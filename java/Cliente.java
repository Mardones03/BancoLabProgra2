import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private ArrayList<CuentasBancarias> cuentasBancarias = new ArrayList<>();

	public Cliente(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<CuentasBancarias> getCuentasBancarias() {
		return cuentasBancarias;
	}

	public void agregarCuentaBancaria(CuentasBancarias cuenta) {
		cuentasBancarias.add(cuenta);
	}

	public String toString() {
		return "Cliente [nombre=" + nombre + ", cuentasBancarias=" + cuentasBancarias + "]";
	}
}