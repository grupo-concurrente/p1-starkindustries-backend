package com.starksecurity.backend.modelos;

import jakarta.persistence.Entity;

@Entity
public class SensorAcceso extends Sensor {
    public SensorAcceso() {
    }

    public SensorAcceso(String nombre, String ubicacion, boolean estado) {
        super(nombre, ubicacion, estado);
    }

    public SensorAcceso(long id, String nombre, String ubicacion, boolean estado) {
        super(id, nombre, ubicacion, estado);
    }

    @Override
    public void detect(String valor) {
        System.out.println("Acceso permitido" + valor);
    }
}
