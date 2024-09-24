package com.starksecurity.backend.tareas;

import com.starksecurity.backend.modelos.Sensor;
import com.starksecurity.backend.modelos.SensorAcceso;
import com.starksecurity.backend.modelos.SensorMov;
import com.starksecurity.backend.modelos.SensorTemp;
import com.starksecurity.backend.repositorios.RepositorioLectura;
import com.starksecurity.backend.repositorios.RepositorioSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class SensorScheduler {
    @Autowired
    private RepositorioLectura repositorioLectura;

    @Autowired
    private RepositorioSensor repositorioSensor;

    private final Random random = new Random();

    // Ejecutar cada 10 segundos
    @Scheduled(fixedRate = 10000)
    public void ejecutarTarea() {
        // Filtrar sensores que estén encendidos (estado = true)
        List<Sensor> sensoresEncendidos = repositorioSensor.findByEstado(true);
        System.out.println("Sensores encendidos: " + sensoresEncendidos.size());

        Sensor sensorAleatorio = seleccionarSensorAleatorio(sensoresEncendidos);
        if (sensorAleatorio == null) {
            System.out.println("No hay sensores disponibles.");
        } else {
            System.out.println("Sensor seleccionado: " + sensorAleatorio.getNombre());
            sensorAleatorio.detect(generarValorAleatorio(sensorAleatorio), repositorioLectura);
        }
    }

    private Sensor seleccionarSensorAleatorio(List<Sensor> sensores) {
        if (sensores.isEmpty()) {
            return null;
        }
        int indiceAleatorio = random.nextInt(sensores.size());
        return sensores.get(indiceAleatorio);
    }

    private String generarValorAleatorio(Sensor sensor) {
        if (sensor instanceof SensorAcceso) {
            return random.nextBoolean() ? "Acceso permitido" : "Acceso denegado";
        } else if (sensor instanceof SensorMov) {
            return random.nextBoolean() ? "Movimiento detectado" : "Sin movimiento";
        } else if (sensor instanceof SensorTemp) {
            return String.valueOf(15 + random.nextInt(20)); // Generar temperatura entre 15 y 35 grados
        }
        return "Tipo no válido";
    }
}

