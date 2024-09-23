package com.starksecurity.backend.modelos;

import jakarta.persistence.Entity;

@Entity
public class SensorMov extends Sensor {
    public SensorMov() {
    }

    public SensorMov(String nombre, String ubicacion, boolean estado) {
        super(nombre, ubicacion, estado);
    }

    public SensorMov(long id, String nombre, String ubicacion, boolean estado) {
        super(id, nombre, ubicacion, estado);
    }

    @Override
    public void detect(String valor) {
        System.out.println("Movimiento detectado: " + valor);
    }
}
