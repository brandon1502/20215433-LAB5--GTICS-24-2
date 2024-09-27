package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMascotas")
    private Integer id;

    @Column(name = "nombre_mascota", length = 45)
    private String nombre;

    @Column(name = "genero", length = 45)
    private String genero;

    @Column(name = "edad", length = 45)
    private String edad;

    @Column(name = "fecha_nacimiento", length = 45)
    private String fecha_nacimiento;

    @Column(name = "vacunado", length = 45)
    private String vacunado;

    @Column(name = "Desparasitado", length = 45)
    private String desparacitado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Persona_idPersona")
    private Persona persona;


}
