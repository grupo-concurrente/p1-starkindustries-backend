package com.starksecurity.backend.modelos;

import jakarta.persistence.Entity;

@Entity
public class SensorTemp extends Sensor {
    private Long temperatura;

    @Override
    public void detect(String valor) {
        this.temperatura = Long.parseLong(valor);
        System.out.println("Temperatura detectada: "+this.temperatura);
    }

    public SensorTemp() {
    }

    public SensorTemp(String nombre, String ubicacion, boolean estado) {
        super(nombre, ubicacion, estado);
    }

    public SensorTemp(long id, String nombre, String ubicacion, boolean estado) {
        super(id, nombre, ubicacion, estado);
    }

    @Override
    public String toString() {
        return super.toString() + "Temperatura: " + temperatura + "]";
    }
}
