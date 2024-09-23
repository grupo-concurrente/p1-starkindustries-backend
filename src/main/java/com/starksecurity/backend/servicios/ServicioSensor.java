package com.starksecurity.backend.servicios;

import com.starksecurity.backend.modelos.Sensor;
import com.starksecurity.backend.modelos.SensorTemp;
import com.starksecurity.backend.modelos.SensorMov;
import com.starksecurity.backend.modelos.SensorAcceso;
import com.starksecurity.backend.repositorios.RepositorioSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioSensor {

    private final RepositorioSensor repositorioSensor;

    @Autowired
    public ServicioSensor(RepositorioSensor repositorioSensor) {
        this.repositorioSensor = repositorioSensor;
    }

    // Obtener todos los sensores
    public List<Sensor> getSensores() {
        return repositorioSensor.findAll();
    }

    // Obtener sensores de temperatura
    public List<SensorTemp> getSensoresTemp() {
        return repositorioSensor.findAllTempSensors();
    }

    // Obtener sensores de movimiento
    public List<SensorMov> getSensoresMov() {
        return repositorioSensor.findAllMovSensors();
    }

    // Obtener sensores de acceso
    public List<SensorAcceso> getSensoresAcceso() {
        return repositorioSensor.findAllAccesoSensors();
    }

    // Agregar un nuevo sensor
    public void addNewSensor(Sensor sensor) {
        Optional<Sensor> sensorPorNombre = repositorioSensor.findSensorByName(sensor.getNombre());
        if (sensorPorNombre.isPresent()) {
            throw new IllegalArgumentException("El sensor ya existe");
        }
        repositorioSensor.save(sensor);
    }

    // Eliminar un sensor por ID
    public void deleteSensor(Long id) {
        boolean exists = repositorioSensor.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El sensor con id " + id + " no existe.");
        }
        repositorioSensor.deleteById(id);
    }
}
