package com.starksecurity.backend.modelos;

import com.starksecurity.backend.repositorios.RepositorioLectura;
import jakarta.persistence.Entity;
@Entity
public class SensorAcceso extends Sensor {
        private String acceso;

    public SensorAcceso() {
    }

    public SensorAcceso(String nombre, String ubicacion, boolean estado) {
        super(nombre, ubicacion, estado);
    }

    public SensorAcceso(long id, String nombre, String ubicacion, boolean estado) {
        super(id, nombre, ubicacion, estado);
    }

    @Override
    public void detect(String valor, RepositorioLectura repositorioLectura) {
        super.detect(valor, repositorioLectura);

        // Imprimir mensaje de detección (puedes personalizar o sustituir por lógica más avanzada)
        System.out.println("Sensor de acceso detectó valor: " + valor);
    }

        @Override
        public String toString() {
            return super.toString() + "Acceso: " + acceso + "]";
        }
}
