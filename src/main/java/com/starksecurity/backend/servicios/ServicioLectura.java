package com.starksecurity.backend.servicios;

import com.starksecurity.backend.modelos.Lectura;
import com.starksecurity.backend.modelos.Sensor;
import com.starksecurity.backend.repositorios.RepositorioLectura;
import com.starksecurity.backend.repositorios.RepositorioSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioLectura {

    private final RepositorioLectura repositorioLectura;
    private final RepositorioSensor repositorioSensor;

    @Autowired
    public ServicioLectura(RepositorioLectura repositorioLectura, RepositorioSensor repositorioSensor) {
        this.repositorioLectura = repositorioLectura;
        this.repositorioSensor = repositorioSensor;
    }

    // Obtener todas las lecturas
    public List<Lectura> getLecturas() {
        return repositorioLectura.findAll();
    }

    // Obtener lecturas por sensor
    public List<Lectura> getLecturasBySensor(Long sensorId) {
        Sensor sensor = repositorioSensor.findById(sensorId)
                .orElseThrow(() -> new IllegalStateException("Sensor no encontrado"));
        return repositorioLectura.findBySensor(sensor);
    }

    // Agregar nueva lectura
    public void addLectura(Lectura lectura) {
        repositorioLectura.save(lectura);
    }

    // Eliminar lectura por ID
    public void deleteLectura(Long lecturaId) {
        boolean exists = repositorioLectura.existsById(lecturaId);
        if (!exists) {
            throw new IllegalStateException("La lectura con id " + lecturaId + " no existe.");
        }
        repositorioLectura.deleteById(lecturaId);
    }
}
