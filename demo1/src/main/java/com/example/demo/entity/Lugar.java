package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "lugares")
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLugares")
    private Integer id;

    @Column(name = "nombre_lugar", length = 45)
    private String nombre;

    @Column(name = "descrip_lugar", length = 45)
    private String descripcion;

    @Column(name = "fecha_lugar", length = 45)
    private Date fecha;
}
