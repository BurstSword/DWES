/*Bibliografía utilizada:
 * Material didactico de la asignatura
 * https://www.udemy.com/course/fundamentos-de-java-aprende-a-programar-java-desde-cero-sin-misterios/?ranMID=39197&ranEAID=hL3Qp0zRBOc&ranSiteID=hL3Qp0zRBOc-BCezaPKFa1oDDdvKNK38qQ&LSNPUBID=hL3Qp0zRBOc&awc=6554_1603217600_822f2f391a496d1154a3e7018166b8eb&utm_source=Growth-Affiliate&utm_medium=Affiliate-Window&utm_campaign=Campaign-Name&utm_term=375095&utm_content=Placement&ranMID=39197&ranEAID=hL3Qp0zRBOc&ranSiteID=hL3Qp0zRBOc-P8VLOZ7rLpz4WhSiuEBaFg&LSNPUBID=hL3Qp0zRBOc&utm_source=aff-campaign&utm_medium=udemyads
 * http://prof.mfbarcell.es/programacion-orientada-objetos/
 * https://www.udemy.com/course/aprende-programacion-en-java-desde-cero/
 * Pildoras Informáticas https://www.youtube.com/watch?v=coK4jM5wvko
*/

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

	//Atributos declarados
	private double saldo;
	private Usuario usuario;
	private List<Gasto> gastos;
	private List<Ingreso> ingresos;
	
	//Constructor
	public Cuenta(Usuario usuario) {
		this.usuario = usuario; 
		this.saldo = 0.0;
		
		//Colecciones en el constructor
		this.ingresos = new ArrayList<>();
		this.gastos = new ArrayList<>();
	}
	
	//Getters y setters
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double addIngresos(String descripcion, double cantidad) {
		//Agregar ingresos
		ingresos.add(new Ingreso(cantidad, descripcion)); 
		//Aumento de ese ingreso en el saldo
		this.saldo += cantidad; 
		
		//Imprimo el saldo
		return this.getSaldo();
	}

	public double addGastos(String descripcion, double cantidad) throws GastoException {
		
		boolean condicionGastoException = this.getSaldo()<cantidad;
		
		//Verifico el saldo y luego resto si el resultado es mayor que 0 o insuficiente. En el caso contrario, parará
		if(condicionGastoException) {
			throw new GastoException(); 
		}
		
		//Agregar un gasto
		gastos.add(new Gasto(cantidad, descripcion));
		
		//Saldo con el gasto quitado
		this.saldo -= cantidad; 
		return this.getSaldo(); 
	}

	public List<Ingreso> getIngresos() {
		return ingresos;
	}
	
	public List<Gasto> getGastos() {
		return gastos;
	}
	
	@Override
	public String toString() {
	
		return  "Hola " + this.getUsuario() + ", su saldo asciende a: " + this.getSaldo(); 
	}
}
