public class CuentaCorriente extends CuentasBancarias {
	private int lineaSobregiro;

	public CuentaCorriente(String numeroCuenta, int lineaSobregiro, Cliente cliente, Sucursal sucursal) {
		super();
		this.setNumeroCuenta(numeroCuenta);
		this.lineaSobregiro = lineaSobregiro;
		this.setCliente(cliente);
		this.setSucursal(sucursal);
	}

	@Override
	public String getTipo() {
		return "Cuenta Corriente";
	}

	public int getLineaSobregiro() {
		return this.lineaSobregiro;
	}

	public void setLineaSobregiro(int lineaSobregiro) {
		this.lineaSobregiro = lineaSobregiro;
	}

	@Override
	public void mostrarDetallesCuenta() {
		System.out.println("Número de Cuenta: " + getNumeroCuenta());
		System.out.println("Tipo de Cuenta: " + getTipo());
		System.out.println("Saldo: " + getSaldo());
		System.out.println("Línea de Sobregiro: " + lineaSobregiro);
		System.out.println("Cliente: " + getCliente().getNombre());
		System.out.println("Sucursal: " + getSucursal());
	}
}