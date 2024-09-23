package com.starksecurity.backend.modelos;

import jakarta.persistence.Entity;

@Entity
public class SensorTemp extends Sensor {
    public SensorTemp() {
    }

    public SensorTemp(String nombre, String ubicacion, boolean estado) {
        super(nombre, ubicacion, estado);
    }

    public SensorTemp(long id, String nombre, String ubicacion, boolean estado) {
        super(id, nombre, ubicacion, estado);
    }

    @Override
    public void detect(String valor) {
        System.out.println("Temperatura detectada: " + valor);
    }
}
