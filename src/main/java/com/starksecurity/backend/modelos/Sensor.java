package com.starksecurity.backend.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sensores")
public abstract class Sensor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @Getter @Setter
    private String nombre, ubicacion;
    @Getter @Setter
    private boolean estado;

    public Sensor() {
    }
    public Sensor(String nombre, String ubicacion, boolean estado) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }
    public Sensor(long id, String nombre, String ubicacion, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }
    public abstract void detectar(String valor); // detecta un valor y lo almacena en la base de datos


    @Override
    public String toString() {
        return "Sensor[" +
                "Id: " + id +
                ", Nombre: " + nombre + '\'' +
                ", Ubicacion: " + ubicacion + '\'' +
                ", Estado:" + estado +
                ']';
    }
}
