package com.starksecurity.backend.modelos;

import com.starksecurity.backend.repositorios.RepositorioLectura;
import jakarta.persistence.Entity;

@Entity
public class SensorAcceso extends Sensor {
    public SensorAcceso() {
    }

    public SensorAcceso(String nombre, String ubicacion, boolean estado) {
        super(nombre, ubicacion, estado, TipoSensor.ACCESO);
    }

    public SensorAcceso(long id, String nombre, String ubicacion, boolean estado) {
        super(id, nombre, ubicacion, estado, TipoSensor.ACCESO);
    }

    @Override
    public void detect(String valor, RepositorioLectura repositorioLectura) {
        super.detect(valor, repositorioLectura);

        // Imprimir mensaje de detección (puedes personalizar o sustituir por lógica más avanzada)
        System.out.println("Sensor de acceso detectó valor: " + valor);
    }
}
