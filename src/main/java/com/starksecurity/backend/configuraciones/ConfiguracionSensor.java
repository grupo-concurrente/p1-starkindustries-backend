package com.starksecurity.backend.configuraciones;

import com.starksecurity.backend.modelos.*;
import com.starksecurity.backend.repositorios.RepositorioLectura;
import com.starksecurity.backend.repositorios.RepositorioSensor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class ConfiguracionSensor {

    @Bean
    CommandLineRunner sensorRunner(RepositorioSensor repositorioSensor, RepositorioLectura repositorioLectura) {
        return args -> {
            // Creamos los sensores
            SensorTemp sensor1on = new SensorTemp( "sensor1", "Vestibulo", true);
            SensorTemp sensor2off = new SensorTemp( "sensor2", "Entrada", false);
            SensorMov sensor3on = new SensorMov( "sensor3", "Despacho", true);
            SensorAcceso sensor4on = new SensorAcceso( "sensor4", "Entrada", true);

            // Guardamos los sensores en la base de datos
            repositorioSensor.deleteAll();
            repositorioSensor.saveAll(List.of(sensor1on, sensor2off, sensor3on, sensor4on));

            // Creamos las lecturas para sensor1on
            Lectura lectura1 = new Lectura("25.5", sensor1on, LocalDateTime.of(2024, 8, 27, 14, 0));
            Lectura lectura2 = new Lectura("24.5", sensor1on, LocalDateTime.of(2024, 8, 27, 14, 35));
            Lectura lectura3 = new Lectura("26.2", sensor1on, LocalDateTime.of(2024, 8, 27, 14, 50));
            Lectura lectura4 = new Lectura("22.5", sensor1on, LocalDateTime.of(2024, 8, 27, 15, 15));
            Lectura lectura5 = new Lectura("23.5", sensor1on, LocalDateTime.of(2024, 8, 27, 16, 20));

            // Creamos lecturas para sensor2off (aunque esté apagado, podríamos tener datos previos)
            Lectura lectura6 = new Lectura("20.0", sensor2off, LocalDateTime.of(2024, 8, 27, 14, 0));
            Lectura lectura7 = new Lectura("18.8", sensor2off, LocalDateTime.of(2024, 8, 27, 14, 30));
            Lectura lectura8 = new Lectura("21.0", sensor2off, LocalDateTime.of(2024, 8, 27, 15, 0));

            // Creamos lecturas para sensor3on (sensor de movimiento)
            Lectura lectura9 = new Lectura("Movimiento detectado", sensor3on, LocalDateTime.of(2024, 8, 27, 14, 15));
            Lectura lectura10 = new Lectura("Sin movimiento", sensor3on, LocalDateTime.of(2024, 8, 27, 14, 45));
            Lectura lectura11 = new Lectura("Movimiento detectado", sensor3on, LocalDateTime.of(2024, 8, 27, 15, 10));
            Lectura lectura12 = new Lectura("Movimiento detectado", sensor3on, LocalDateTime.of(2024, 8, 27, 15, 15));
            Lectura lectura13 = new Lectura("Sin movimiento", sensor3on, LocalDateTime.of(2024, 8, 27, 15, 45));
            Lectura lectura14 = new Lectura("Movimiento detectado", sensor3on, LocalDateTime.of(2024, 8, 27, 16, 10));

            // Creamos lecturas para sensor4on (sensor de acceso)
            Lectura lectura15 = new Lectura("Acceso denegado", sensor4on, LocalDateTime.of(2024, 8, 27, 14, 20));
            Lectura lectura16 = new Lectura("Acceso permitido", sensor4on, LocalDateTime.of(2024, 8, 27, 14, 50));
            Lectura lectura17 = new Lectura("Acceso permitido", sensor4on, LocalDateTime.of(2024, 8, 27, 15, 25));
            Lectura lectura18 = new Lectura("Acceso permitido", sensor4on, LocalDateTime.of(2024, 8, 27, 15, 40));
            Lectura lectura19 = new Lectura("Acceso denegado", sensor4on, LocalDateTime.of(2024, 8, 27, 15, 50));
            Lectura lectura20 = new Lectura("Acceso permitido", sensor4on, LocalDateTime.of(2024, 8, 27, 16, 25));

            // Guardamos todas las lecturas en la base de datos
            repositorioLectura.deleteAll();
            repositorioLectura.saveAll(List.of(
                    lectura1, lectura2, lectura3, lectura4, lectura5,
                    lectura6, lectura7, lectura8,
                    lectura9, lectura10, lectura11,
                    lectura12, lectura13, lectura14,
                    lectura15, lectura16, lectura17,
                    lectura18, lectura19, lectura20
            ));
        };
    }
}
