
package model;

public class Nomina {
	
	
	private int sueldo;
	private String dniEmp;
	
	
	
    public Nomina(int sueldo, String dniEmp) {
		super();
		this.sueldo = sueldo;
		this.dniEmp = dniEmp;
	}
    
    

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public String getDniEmp() {
		return dniEmp;
	}

	public void setDniEmp(String dniEmp) {
		this.dniEmp = dniEmp;
	}



	private static final int[] SUELDO_BASE = {50000, 70000, 90000, 110000, 130000,
            150000, 170000, 190000, 210000, 230000};

    /**
     * Metodo que se encarga de calcular el sueldo de un empleado
     * @param empleado El empleado al que se le calcula el sueldo
     * @return El sueldo del empleado enviado ya calculado
     */
     public static int sueldo(Empleado empleado,int categoria){
        int sueldo;
        sueldo = SUELDO_BASE[categoria-1]+5000*empleado.getAnyos();
        return sueldo;
    }
}
