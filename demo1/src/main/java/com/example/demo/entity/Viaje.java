package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "viajes")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViajes")
    private Integer id;

    @Column(name = "punto_recojo", length = 45)
    private String punto_recojo;

    @Column(name = "cant_personas", length = 45)
    private String cant_personas;

    @Column(name = "cant_perros", length = 45)
    private String cant_perros;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Persona_idPersona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Lugares_idLugares")
    private Lugar lugar;


}
