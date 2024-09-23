package com.starksecurity.backend.tareas;

import com.starksecurity.backend.modelos.Sensor;
import com.starksecurity.backend.modelos.SensorAcceso;
import com.starksecurity.backend.modelos.SensorMov;
import com.starksecurity.backend.modelos.SensorTemp;
import com.starksecurity.backend.repositorios.RepositorioLectura;
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
    private List<Sensor> sensores;

    private Random random = new Random();

    // ejecutar cada 10 segundos
    @Scheduled(fixedRate = 10000)
    public void ejecutarTarea() {
        Sensor sensorAleatorio = seleccionarSensorAleatorio();
        if (sensorAleatorio != null) {
            String valorAleatorio = generarValorAleatorio(sensorAleatorio);
            sensorAleatorio.detect(valorAleatorio, repositorioLectura);
        }
    }

    private Sensor seleccionarSensorAleatorio() {
        if (sensores.isEmpty()) {
            return null;
        }
        int indiceAleatorio = random.nextInt(sensores.size());
        return sensores.get(indiceAleatorio);
    }

    private String generarValorAleatorio(Sensor sensor) {
        if (sensor instanceof SensorAcceso) {
            return random.nextBoolean() ? "activo" : "desactivado";
        } else if (sensor instanceof SensorMov) {
            return random.nextBoolean() ? "movimiento detectado" : "sin movimiento";
        } else if (sensor instanceof SensorTemp) {
            return String.valueOf(15 + random.nextInt(20)); //generar temperatura entre 15 y 35
        }
        return "valor no definido";
    }
}
