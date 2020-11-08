package springmvc.entity;




import javax.persistence.*;

@Entity
@Table(name="nomina")
public class Nomina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "sueldo")
    private int sueldo;

    public Nomina() {
    }

    public Nomina(String dni, int sueldo) {
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
}
