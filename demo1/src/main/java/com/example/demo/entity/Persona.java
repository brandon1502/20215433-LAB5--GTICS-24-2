package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "dni", length = 45)
    private String dni;

    @Column(name = "celular", length = 45)
    private String celular;

    @Column(name = "tipo_persona", length = 45)
    private String tipo;
}
