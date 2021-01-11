package com.nomina.nomina.entity;



import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "dni")
    private String dni;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "categoria")
    private int categoria;

    @Column(name = "antiguedad")
    private int antiguedad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nomina_id")
    private Nomina nomina;

    public Empleado() {

    }

    public Empleado(String nombre, String dni, String sexo, int categoria, int antiguedad) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
        this.categoria = categoria;
        this.antiguedad = antiguedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Nomina getNomina() {
        return nomina;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", sexo=" + sexo + ", categoria="
				+ categoria + ", antiguedad=" + antiguedad + ", nomina=" + nomina + "]";
	}
    
    
}
