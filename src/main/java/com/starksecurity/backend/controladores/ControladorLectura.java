package com.starksecurity.backend.controladores;

import com.starksecurity.backend.modelos.Lectura;
import com.starksecurity.backend.servicios.ServicioLectura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("publico/api/v1/lecturas")
@CrossOrigin(origins = "http://localhost:5173")
public class ControladorLectura {

    private final ServicioLectura servicioLectura;

    @Autowired
    public ControladorLectura(ServicioLectura servicioLectura) {
        this.servicioLectura = servicioLectura;
    }

    // Obtener todas las lecturas
    @GetMapping
    public List<Lectura> getLecturas() {
        return servicioLectura.getLecturas();
    }

    // Obtener lecturas por sensor
    @GetMapping("/sensor/{sensorId}")
    public List<Lectura> getLecturasBySensor(@PathVariable("sensorId") Long sensorId) {
        return servicioLectura.getLecturasBySensor(sensorId);
    }

    // Agregar nueva lectura
    @PostMapping
    public void addLectura(@RequestBody Lectura lectura) {
        servicioLectura.addLectura(lectura);
    }

    // Eliminar lectura por ID
    @DeleteMapping("/{lecturaId}")
    public void deleteLectura(@PathVariable("lecturaId") Long lecturaId) {
        servicioLectura.deleteLectura(lecturaId);
    }
}
