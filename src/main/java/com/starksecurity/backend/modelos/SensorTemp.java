package com.starksecurity.backend.modelos;

import com.starksecurity.backend.repositorios.RepositorioLectura;
import jakarta.persistence.Entity;

@Entity
public class SensorTemp extends Sensor {

    public SensorTemp() {
    }

    public SensorTemp(String nombre, String ubicacion, boolean estado) {
        super(nombre, ubicacion, estado, TipoSensor.TEMPERATURA);
    }

    public SensorTemp(long id, String nombre, String ubicacion, boolean estado) {
        super(id, nombre, ubicacion, estado, TipoSensor.TEMPERATURA);
    }

    @Override
    public void detect(String valor, RepositorioLectura repositorioLectura) {
        super.detect(valor, repositorioLectura);

        // Imprimir mensaje de detección (puedes personalizar o sustituir por lógica más avanzada)
        System.out.println("Sensor de temperatura detectó valor: " + valor);
    }
}
