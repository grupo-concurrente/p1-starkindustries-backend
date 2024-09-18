package com.starksecurity.backend.modelos;

import jakarta.persistence.Entity;
@Entity
public class SensorAcceso extends Sensor {
        private String acceso;

        @Override
        public void detect(String valor) {
            this.acceso = valor;
            System.out.println("Acceso permitido" + acceso);
        }

        @Override
        public String toString() {
            return super.toString() + "Acceso: " + acceso + "]";
        }
}
