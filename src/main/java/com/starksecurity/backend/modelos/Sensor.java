package com.starksecurity.backend.modelos;

import com.starksecurity.backend.repositorios.RepositorioLectura;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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

    @Getter
    @Enumerated(EnumType.STRING)
    TipoSensor tipo;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lectura> lecturas;

    public Sensor() {
    }

    public Sensor(String nombre, String ubicacion, boolean estado, TipoSensor tipo) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Sensor(long id, String nombre, String ubicacion, boolean estado, TipoSensor tipo) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.tipo = tipo;
    }

    public void detect(String valor, RepositorioLectura repositorioLectura){
        // Crear una nueva lectura con el valor recibido y la fecha actual
        Lectura lectura = new Lectura(valor, this, LocalDateTime.now());

        // Guardar la lectura en la base de datos
        repositorioLectura.save(lectura);
    }

    @Override
    public String toString() {
        return "Sensor[" +
                "Id: " + id +
                ", Nombre: " + nombre + '\'' +
                ", Ubicacion: " + ubicacion + '\'' +
                ", Estado:" + estado;
    }
}
