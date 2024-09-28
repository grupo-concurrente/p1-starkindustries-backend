package com.starksecurity.backend.modelos;

import com.starksecurity.backend.repositorios.RepositorioLectura;
import jakarta.persistence.Entity;

@Entity
public class SensorMov extends Sensor {
    public SensorMov() {
    }

    public SensorMov(String nombre, String ubicacion, boolean estado) {
        super(nombre, ubicacion, estado, TipoSensor.MOVIMIENTO);
    }

    public SensorMov(long id, String nombre, String ubicacion, boolean estado) {
        super(id, nombre, ubicacion, estado, TipoSensor.MOVIMIENTO);
    }

    @Override
    public void detect(String valor, RepositorioLectura repositorioLectura) {
        super.detect(valor, repositorioLectura);

        // Imprimir mensaje de detección (puedes personalizar o sustituir por lógica más avanzada)
        System.out.println("Sensor de movimiento detectó valor: " + valor);
    }
}
