package com.nomina.nomina.entity;


import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    @Length(min = 1, max = 45, message = "Entre 0 y 45 caracteres")
    @NotNull(message = "is required")
    private String nombre;

    @Column(name = "dni")
    @Pattern(regexp = "^[0-9]{8}[A-Za-z]$", message = "8 numeros y 1 letra")
    private String dni;

    @Column(name = "sexo")
    @NotNull(message = "is required")
    @Pattern(regexp = "^[HM]$", message = "M o H mayuscula")
    private String sexo;

    @Column(name = "categoria")
    @NotNull(message = "is required")
    @Range(min = 1, max = 10, message = "Entre 1 y 10")
    private int categoria;

    @Column(name = "antiguedad")
    @NotNull(message = "Minimo 0 años trabajados")
    @Range(min = 0, max = 60, message = "Entre 0 y 60")
    private int antiguedad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nomina_id")
    private Nomina nomina;

}
