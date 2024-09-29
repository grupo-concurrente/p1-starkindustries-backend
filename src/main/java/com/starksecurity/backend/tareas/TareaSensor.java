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

@Component
public class TareaSensor {

    private final RepositorioSensor repositorioSensor;
    private final RepositorioLectura repositorioLectura;
    private final ExecutorService executorService = Executors.newFixedThreadPool(4); // Pool de 4 hilos

    private final Random random = new Random();

    public TareaSensor(RepositorioSensor repositorioSensor, RepositorioLectura repositorioLectura) {
        this.repositorioSensor = repositorioSensor;
        this.repositorioLectura = repositorioLectura;
    }

    @Scheduled(fixedRate = 10000)
    public void ejecutarTarea() {
        // Filtrar sensores que estén encendidos (estado = true)
        List<Sensor> sensoresEncendidos = repositorioSensor.findByEstado(true);
        System.out.println("Sensores encendidos: " + sensoresEncendidos.size());

        for (Sensor sensor : sensoresEncendidos) {
            // Ejecutar cada sensor en un hilo separado
            executorService.submit(() -> procesarSensor(sensor));
        }
    }

    private Sensor seleccionarSensorAleatorio(List<Sensor> sensores) {
        if (sensores.isEmpty()) {
            return null;
        }
        int indiceAleatorio = random.nextInt(sensores.size());
        return sensores.get(indiceAleatorio);
    }

    private void procesarSensor(Sensor sensor) {
        String valorGenerado = generarValorAleatorio(sensor);
        System.out.println("Procesando sensor: " + sensor.getNombre() + ", Valor: " + valorGenerado);
        sensor.detect(valorGenerado, repositorioLectura); // Guardar la lectura en el repositorio
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

