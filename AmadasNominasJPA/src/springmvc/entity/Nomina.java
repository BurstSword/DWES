package springmvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "nomina")
public class Nomina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "sueldo")
    private int sueldo;
    
    @OneToOne(mappedBy="nomina", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
    private Empleado empleado;
    
    private static final int SUELDO_BASE[] = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000,
            230000 };

    public Nomina() {
    }

    public Nomina(int id, String dni, int sueldo) {
    	this.id = id;
        this.dni = dni;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Nomina [id=" + id + ", dni=" + dni + ", sueldo=" + sueldo + "]";
	}
    
	public int sueldo(int categoria, int anyos) {
        int sueldo;
        int sueldoBase = SUELDO_BASE[categoria - 1];

        sueldo = sueldoBase + (5000 * anyos);

        return sueldo;
    }
}
