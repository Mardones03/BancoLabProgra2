public class CuentaAhorro extends CuentasBancarias {
	private double reajusteAnual;

	public CuentaAhorro(String numeroCuenta, double reajusteAnual, Cliente cliente, Sucursal sucursal) {
		super();
		this.setNumeroCuenta(numeroCuenta);
		this.reajusteAnual = reajusteAnual;
		this.setCliente(cliente);
		this.setSucursal(sucursal);
	}

	@Override
	public String getTipo() {
		return "Cuenta de Ahorro";
	}

	public double getReajusteAnual() {
		return this.reajusteAnual;
	}

	public void setReajusteAnual(double reajusteAnual) {
		this.reajusteAnual = reajusteAnual;
	}

	@Override
	public void mostrarDetallesCuenta() {
		System.out.println("Número de Cuenta: " + getNumeroCuenta());
		System.out.println("Tipo de Cuenta: " + getTipo());
		System.out.println("Saldo: " + getSaldo());
		System.out.println("Reajuste Anual: " + reajusteAnual);
		System.out.println("Cliente: " + getCliente().getNombre());
		System.out.println("Sucursal: " + getSucursal());
	}
}