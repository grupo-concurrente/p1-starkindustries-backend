package com.starksecurity.backend.modelos;

import jakarta.persistence.Entity;

@Entity
public class SensorTemp extends Sensor {
    private Long temperatura;

    @Override
    public void detect(String valor) {
        this.temperatura = Long.parseLong(valor);
        System.out.println("Temperatura correcta: " + temperatura);
    }

    @Override
    public String toString() {
        return super.toString() + "Temperatura: " + temperatura + "]";
    }
}
