package com.nomina.nomina.entity;

import lombok.*;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
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
    
    private static final int[] SUELDO_BASE = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000,
            230000 };

	public int sueldo(int categoria, int anyos) {
        int sueldo;
        int sueldoBase = SUELDO_BASE[categoria - 1];

        sueldo = sueldoBase + (5000 * anyos);

        return sueldo;
    }
}
