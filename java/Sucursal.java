import java.util.ArrayList;

public class Sucursal {
	private String codigoSucursal;
	private String codigoPostal;
	private ArrayList<CuentasBancarias> cuentasBancarias = new ArrayList<>();

	public String getCodigoSucursal() {
		return codigoSucursal;
	}

	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Sucursal(String codigoSucursal, String codigoPostal) {
		this.codigoSucursal = codigoSucursal;
		this.codigoPostal = codigoPostal;
	}

	public ArrayList<CuentasBancarias> getCuentasBancarias() {
		return cuentasBancarias;
	}

	public void agregarCuentaBancaria(CuentasBancarias cuenta) {
		cuentasBancarias.add(cuenta);
	}

	@Override
	public String toString() {
		return "Sucursal [codigoSucursal=" + codigoSucursal + ", codigoPostal=" + codigoPostal + "]";
	}
}