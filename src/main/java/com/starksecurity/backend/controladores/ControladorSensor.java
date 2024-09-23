package com.starksecurity.backend.controladores;

import com.starksecurity.backend.modelos.Sensor;
import com.starksecurity.backend.modelos.SensorTemp;
import com.starksecurity.backend.modelos.SensorMov;
import com.starksecurity.backend.modelos.SensorAcceso;
import com.starksecurity.backend.servicios.ServicioSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sensores")
public class ControladorSensor {

    private final ServicioSensor servicioSensor;

    @Autowired
    public ControladorSensor(ServicioSensor servicioSensor) {
        this.servicioSensor = servicioSensor;
    }

    // Obtener todos los sensores
    @GetMapping
    public List<Sensor> getSensores() {
        return servicioSensor.getSensores();
    }

    // Obtener sensores de temperatura
    @GetMapping("/temperatura")
    public List<SensorTemp> getSensoresTemp() {
        return servicioSensor.getSensoresTemp();
    }

    // Obtener sensores de movimiento
    @GetMapping("/movimiento")
    public List<SensorMov> getSensoresMov() {
        return servicioSensor.getSensoresMov();
    }

    // Obtener sensores de acceso
    @GetMapping("/acceso")
    public List<SensorAcceso> getSensoresAcceso() {
        return servicioSensor.getSensoresAcceso();
    }

    // Agregar un nuevo sensor
    @PostMapping
    public void addSensor(@RequestBody Sensor sensor) {
        servicioSensor.addNewSensor(sensor);
    }

    // Eliminar un sensor por ID
    @DeleteMapping("/{id}")
    public void deleteSensor(@PathVariable("id") Long id) {
        servicioSensor.deleteSensor(id);
    }
}
