package com.starksecurity.backend.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Lectura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String valor;

    @Getter @Setter
    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    @Getter @Setter
    private Sensor sensor;

    public Lectura(Long id, String valor, LocalDateTime fecha, Sensor sensor) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
        this.sensor = sensor;
    }

    public Lectura() {
        this.fecha = LocalDateTime.now();
    }

    public Lectura(String valor, Sensor sensor) {
        this.valor = valor;
        this.sensor = sensor;
        this.fecha = LocalDateTime.now();
    }

    public Lectura(String valor, Sensor sensor, LocalDateTime time) {
        this.valor = valor;
        this.sensor = sensor;
        this.fecha = time;
    }

    @Override
    public String toString() {
        return "Lectura{" +
                "id=" + id +
                ", valor='" + valor + '\'' +
                ", fecha=" + fecha +
                ", sensor=" + sensor +
                '}';
    }
}
