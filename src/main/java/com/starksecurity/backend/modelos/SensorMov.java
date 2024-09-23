package com.starksecurity.backend.modelos;

import jakarta.persistence.Entity;

@Entity
public class SensorMov extends Sensor {
        private boolean movimiento;

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
            this.movimiento = Boolean.parseBoolean(valor);
            System.out.println("Movimiento detectado: " + valor);
        }

        @Override
        public String toString() {
            return super.toString() + "Movimiento: " + movimiento + "]";
        }
}
