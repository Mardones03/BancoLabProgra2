import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionBanco {
	private Map<String, Cliente> clientes = new HashMap<>();
	private List<CuentasBancarias> cuentas = new ArrayList<>();
	private List<Sucursal> sucursales = new ArrayList<>();

	public void agregarCliente(Cliente cliente) {
		clientes.put(cliente.getNombre(), cliente);
	}

	public void agregarCuentasBancarias(CuentasBancarias cuenta) {
		cuentas.add(cuenta);
	}

	public void agregarSucursal(Sucursal sucursal) {
		sucursales.add(sucursal);
	}

	public ArrayList<CuentasBancarias> verCuentasCliente(String nombreCliente) {
		Cliente cliente = clientes.get(nombreCliente);
		if (cliente != null) {
			return cliente.getCuentasBancarias();
		}
		return null;
	}

	public List<CuentaAhorro> obtenerCuentasAhorro(Sucursal sucursal) {
		List<CuentaAhorro> cuentasAhorro = new ArrayList<>();
		for (CuentasBancarias cuenta : cuentas) {
			if (cuenta instanceof CuentaAhorro && cuenta.getSucursal().equals(sucursal)) {
				cuentasAhorro.add((CuentaAhorro) cuenta);
			}
		}
		return cuentasAhorro;
	}

	public List<CuentaCorriente> obtenerCuentasCorrientes(Sucursal sucursal) {
		List<CuentaCorriente> cuentasCorrientes = new ArrayList<>();
		for (CuentasBancarias cuenta : cuentas) {
			if (cuenta instanceof CuentaCorriente && cuenta.getSucursal().equals(sucursal)) {
				cuentasCorrientes.add((CuentaCorriente) cuenta);
			}
		}
		return cuentasCorrientes;
	}

	public Cliente obtenerClientePorNombre(String nombreCliente) {
		return clientes.get(nombreCliente);
	}

	public Sucursal obtenerSucursalPorCodigo(String codigoSucursal) {
		for (Sucursal sucursal : sucursales) {
			if (sucursal.getCodigoSucursal().equals(codigoSucursal)) {
				return sucursal;
			}
		}
		return null;
	}
}