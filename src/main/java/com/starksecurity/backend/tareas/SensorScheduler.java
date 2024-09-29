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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class SensorScheduler {

    @Autowired
    private RepositorioLectura repositorioLectura;

    @Autowired
    private RepositorioSensor repositorioSensor;

    private final Random random = new Random();
    private final int NUM_THREADS = 2; // Define el número de hilos

    // Ejecutar cada 5 segundos
    @Scheduled(fixedRate = 5000)
    public void ejecutarTarea() {
        // Filtrar sensores que estén encendidos (estado = true)
        List<Sensor> sensoresEncendidos = repositorioSensor.findByEstado(true);
        System.out.println("Sensores encendidos: " + sensoresEncendidos.size());

        // Crear un pool de hilos con un número definido de threads
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        try {
            for (Sensor sensor : sensoresEncendidos) {
                executorService.submit(() -> {
                    // Lógica por cada sensor se ejecutará en paralelo
                    procesarSensor(sensor);
                });
            }
        } finally {
            // Apagar el executor después de que todas las tareas se hayan completado
            executorService.shutdown();

            try {
                if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }
        }
    }

    private void procesarSensor(Sensor sensor) {
        if (sensor == null) {
            System.out.println("No hay sensores disponibles.");
            return;
        }

        System.out.println("Sensor seleccionado: " + sensor.getNombre());
        String valor = generarValorAleatorio(sensor);
        sensor.detect(valor, repositorioLectura);
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
