/*Bibliografía utilizada:
 * Material didactico de la asignatura
 * https://www.udemy.com/course/fundamentos-de-java-aprende-a-programar-java-desde-cero-sin-misterios/?ranMID=39197&ranEAID=hL3Qp0zRBOc&ranSiteID=hL3Qp0zRBOc-BCezaPKFa1oDDdvKNK38qQ&LSNPUBID=hL3Qp0zRBOc&awc=6554_1603217600_822f2f391a496d1154a3e7018166b8eb&utm_source=Growth-Affiliate&utm_medium=Affiliate-Window&utm_campaign=Campaign-Name&utm_term=375095&utm_content=Placement&ranMID=39197&ranEAID=hL3Qp0zRBOc&ranSiteID=hL3Qp0zRBOc-P8VLOZ7rLpz4WhSiuEBaFg&LSNPUBID=hL3Qp0zRBOc&utm_source=aff-campaign&utm_medium=udemyads
 * http://prof.mfbarcell.es/programacion-orientada-objetos/
 * https://www.udemy.com/course/aprende-programacion-en-java-desde-cero/
 * Pildoras Informáticas https://www.youtube.com/watch?v=coK4jM5wvko
*/

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	
	private static final String MSG_DESPEDIDA = "Fin del programa.\nGracias por utilizar la aplicación.";
	
	//Errores y sus mensajes
	private static final String MSG_ACCION_NO_VALIDA = "Accion no valida, elija una nueva acción";
	private static final String MSG_DNI_NO_VALIDO = "DNI introducido incorrecto";
	
	
	//Menú y sus mensajes
	private static final String MSG_MENU = 
							"Realiza una nueva acción\n" +
							"1 Introduce un nuevo gasto\n" +
							"2 Introduce un nuevo ingreso\n" +
							"3 Mostrar gastos\n" +
							"4 Mostrar ingresos\n" +
							"5 Mostrar saldo\n" +
							"0 Salir\n" ;
	
	//Atributos de Usuario 
	private static final String MSG_SOLICITAR_NOMBRE = "Introduce el nombre de usuario: ";
	private static final String MSG_SOLICITAR_EDAD = "Introduce la edad del usuario: ";
	private static final String MSG_SOLICITAR_DNI = "Introduce el DNI del usuario: ";
	private static final String MSG_USUARIO_CREADO = "Usuario creado correctamente ";
	
	//Gasto
	private static final String MSG_SOLICITAR_DESCRIPCION_GASTO = "Descripcion del gasto: ";
	private static final String MSG_SOLICITAR_NUEVO_GASTO = "Introduzca cantidad a gastar: ";
	
	//Ingreso
	private static final String MSG_SOLICITAR_DESCRIPCION_INGRESO = "Introduce descripción: ";
	private static final String MSG_SOLICITAR_NUEVO_INGRESO = "Introduce la cantidad: ";
	
	//Numeración para las acciones
	private static final int NUEVO_GASTO = 1; 
	private static final int NUEVO_INGRESO = 2; 
	private static final int MOSTRAR_GASTOS = 3; 
	private static final int MOSTRAR_INGRESOS = 4; 
	private static final int MOSTRAR_SALDO = 5; 
	private static final int SALIR = 0;

	//Saldo
	private static final String MSG_SALDO_RESTANTE = "Cuent con un saldo restante de: ";
	private static final String MSG_SALDO_ACTUAL = "Dispone actualmente de un saldo en la cuenta ascendente a: ";

	//Objeto y sus variables
	private static Cuenta miCuenta;
	
	public static void main(String[] args) {
		
		solicitarDatos(); 
		
		boolean condicionSalir = true; 
		int opcion; 

		do {
			mostraMenu();
			opcion = elegirOpcion();
			condicionSalir = ejecutarOpcion(opcion); 
		} while (condicionSalir);
	}

	//Main y sus métodos
	private static void solicitarDatos() {
		
		//Nuevo usuario
		Usuario miUsuario = new Usuario(); 
		
		boolean DNICorrecto = false;
		
			String nombre = solicitarString(MSG_SOLICITAR_NOMBRE); 
	
			while(nombre.isEmpty()) {
				nombre = solicitarString(MSG_SOLICITAR_NOMBRE); 
			}
			
			int edad = solicitarEntero(MSG_SOLICITAR_EDAD);
			miUsuario.setNombre(nombre);
			miUsuario.setEdad(edad);
			
		//Comprobación que se cumple dni
		do {
			String DNI = solicitarString(MSG_SOLICITAR_DNI); 
			miUsuario.setDNI(DNI);
			
			if(miUsuario.setDNI(DNI)) {
				DNICorrecto = true; 
			}else {
				System.out.println(MSG_DNI_NO_VALIDO);
			}
			
		} while (!DNICorrecto );
		
		System.out.println(MSG_USUARIO_CREADO);
		
		//Crear la cuenta
		miCuenta = new Cuenta(miUsuario);
		 
	}

	private static void mostraMenu() {
		System.out.print(MSG_MENU);
	}
	
	private static int elegirOpcion() {
		return leerEntero(); 
	}

	private static boolean ejecutarOpcion(int opcion) {
		
		switch (opcion) {
		case NUEVO_GASTO:
			nuevoGasto(); 
			break;
		case NUEVO_INGRESO:
			nuevoIngreso();
			break;
		case MOSTRAR_GASTOS:
			mostrarGastos();
			break;
		case MOSTRAR_INGRESOS:
			mostrarIngresos();
			break;
		case MOSTRAR_SALDO:
			mostrarSaldo();
			break;
		case SALIR:
			System.out.println(MSG_DESPEDIDA);
			return false; 
			
		default:
			System.out.println(MSG_ACCION_NO_VALIDA);
			break;
		}
		return true; 
	}

	//ejecutrarOpcion()
	private static void nuevoGasto() {
		
		String descripcion = solicitarString(MSG_SOLICITAR_DESCRIPCION_GASTO); 
		double cantidad = solicitarDouble(MSG_SOLICITAR_NUEVO_GASTO);
		
		//Error para saldo insuficiente
		try {
			double saldo = miCuenta.addGastos(descripcion,cantidad);
			System.out.println(MSG_SALDO_RESTANTE + saldo);
		} catch (GastoException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void nuevoIngreso() {
		
		String descripcion = solicitarString(MSG_SOLICITAR_DESCRIPCION_INGRESO); 
		double cantidad = solicitarDouble(MSG_SOLICITAR_NUEVO_INGRESO);
		double saldo = miCuenta.addIngresos(descripcion,cantidad);
		
		System.out.println(MSG_SALDO_RESTANTE + saldo);
	}
	
	private static void mostrarIngresos() {
		
		//Copias de listas de ingresos y trabajo
		List<Ingreso> listaIngresos = miCuenta.getIngresos(); 
		
		Stream<Ingreso> str = listaIngresos.stream(); 
		str.forEach(System.out::println);
	}

	private static void mostrarGastos() {
		
		List<Gasto> listaGastos = miCuenta.getGastos(); 
		
		//Accedemos a la lista de gasto
		for (int i = 0; i < listaGastos.size(); i++) {
			System.out.println(listaGastos.get(i));
		}
	}
	
	private static void mostrarSaldo() {
		System.out.println(MSG_SALDO_ACTUAL + miCuenta.getSaldo()+"€");
	}

	//Solicitar los datos por consola
	private static String solicitarString(String mensaje) {
		System.out.println(mensaje);
		return leerString();
	}

	private static int solicitarEntero(String mensaje) {
		System.out.println(mensaje);
		return leerEntero();
	}
	
	private static double solicitarDouble(String mensaje) {
		System.out.println(mensaje);
		return leerDouble(); 
	}
	
	//Leer por consola
	private static String leerString() {
		return new Scanner(System.in).nextLine(); 
	}
	
	private static int leerEntero() {
		try {
			return new Scanner(System.in).nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Introduzca un número entero: ");
			return leerEntero(); 
		}
	}
	
	private static double leerDouble() {
		return new Scanner(System.in).nextDouble();  
	}
}
