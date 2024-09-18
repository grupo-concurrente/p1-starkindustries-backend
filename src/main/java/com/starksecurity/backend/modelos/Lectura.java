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
