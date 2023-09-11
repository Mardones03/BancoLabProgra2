import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionBanco banco = new GestionBanco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Agregar Cuenta Bancaria");
            System.out.println("3. Agregar Sucursal");
            System.out.println("4. Consultar Cuentas de un Cliente");
            System.out.println("5. Consultar Cuentas de Ahorro por Sucursal");
            System.out.println("6. Consultar Cuentas Corrientes por Sucursal");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de la entrada numérica

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del Cliente: ");
                    String nombreCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nombreCliente);
                    banco.agregarCliente(cliente);
                    System.out.println("Cliente agregado exitosamente.");
                    break;
                case 2:
                    System.out.print("Número de Cuenta: ");
                    String numeroCuenta = scanner.nextLine();
                    System.out.print("Tipo de Cuenta (Ahorro/Corriente): ");
                    String tipoCuenta = scanner.nextLine();
                    System.out.print("Saldo Inicial: ");
                    double saldoInicial = scanner.nextDouble();
                    scanner.nextLine(); // Consumir la nueva línea después de la entrada numérica
                    System.out.print("Nombre del Cliente: ");
                    String clienteAsociado = scanner.nextLine();
                    System.out.print("Código de Sucursal: ");
                    String codigoSucursal = scanner.nextLine();

                    Cliente clienteAsociadoObj = banco.obtenerClientePorNombre(clienteAsociado);
                    Sucursal sucursalAsociada = banco.obtenerSucursalPorCodigo(codigoSucursal);

                    if (clienteAsociadoObj == null || sucursalAsociada == null) {
                        System.out.println("No se pudo agregar la cuenta. Cliente o Sucursal no encontrados.");
                    } else {
                        if ("Ahorro".equalsIgnoreCase(tipoCuenta)) {
                            CuentaAhorro cuentaAhorro = new CuentaAhorro(numeroCuenta, 0.02, clienteAsociadoObj, sucursalAsociada);
                            cuentaAhorro.setSaldo(saldoInicial);
                            banco.agregarCuentasBancarias(cuentaAhorro);
                        } else if ("Corriente".equalsIgnoreCase(tipoCuenta)) {
                            System.out.print("Línea de Sobregiro: ");
                            int lineaSobregiro = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea después de la entrada numérica
                            CuentaCorriente cuentaCorriente = new CuentaCorriente(numeroCuenta, lineaSobregiro, clienteAsociadoObj, sucursalAsociada);
                            cuentaCorriente.setSaldo(saldoInicial);
                            banco.agregarCuentasBancarias(cuentaCorriente);
                        } else {
                            System.out.println("Tipo de cuenta no válido.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Código de Sucursal: ");
                    String codigoSucursalNueva = scanner.nextLine();
                    System.out.print("Código Postal: ");
                    String codigoPostal = scanner.nextLine();
                    Sucursal nuevaSucursal = new Sucursal(codigoSucursalNueva, codigoPostal);
                    banco.agregarSucursal(nuevaSucursal);
                    System.out.println("Sucursal agregada exitosamente.");
                    break;
                case 4:
                    System.out.print("Nombre del Cliente: ");
                    String nombreClienteConsulta = scanner.nextLine();
                    Cliente clienteConsulta = banco.obtenerClientePorNombre(nombreClienteConsulta);
                    if (clienteConsulta != null) {
                        System.out.println("Cuentas de " + nombreClienteConsulta + ":");
                        for (CuentasBancarias cuenta : clienteConsulta.getCuentasBancarias()) {
                            System.out.println(cuenta);
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Código de Sucursal: ");
                    String codigoSucursalConsultaAhorro = scanner.nextLine();
                    Sucursal sucursalConsultaAhorro = banco.obtenerSucursalPorCodigo(codigoSucursalConsultaAhorro);
                    if (sucursalConsultaAhorro != null) {
                        System.out.println("Cuentas de Ahorro en Sucursal " + codigoSucursalConsultaAhorro + ":");
                        for (CuentaAhorro cuenta : banco.obtenerCuentasAhorro(sucursalConsultaAhorro)) {
                            System.out.println(cuenta);
                        }
                    } else {
                        System.out.println("Sucursal no encontrada.");
                    }
                    break;
                case 6:
                    System.out.print("Código de Sucursal: ");
                    String codigoSucursalConsultaCorriente = scanner.nextLine();
                    Sucursal sucursalConsultaCorriente = banco.obtenerSucursalPorCodigo(codigoSucursalConsultaCorriente);
                    if (sucursalConsultaCorriente != null) {
                        System.out.println("Cuentas Corrientes en Sucursal " + codigoSucursalConsultaCorriente + ":");
                        for (CuentaCorriente cuenta : banco.obtenerCuentasCorrientes(sucursalConsultaCorriente)) {
                            System.out.println(cuenta);
                        }
                    } else {
                        System.out.println("Sucursal no encontrada.");
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }
    }
}