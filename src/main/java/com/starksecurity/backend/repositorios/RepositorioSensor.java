package com.starksecurity.backend.repositorios;

import com.starksecurity.backend.modelos.Sensor;
import com.starksecurity.backend.modelos.SensorTemp;
import com.starksecurity.backend.modelos.SensorMov;
import com.starksecurity.backend.modelos.SensorAcceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioSensor extends JpaRepository<Sensor, Long> {

    @Query("SELECT s FROM Sensor s WHERE s.nombre = ?1")
    Optional<Sensor> findSensorByName(String nombre);

    // Consultas personalizadas para los distintos tipos de sensores
    @Query("SELECT s FROM SensorTemp s")
    List<SensorTemp> findAllTempSensors();

    @Query("SELECT s FROM SensorMov s")
    List<SensorMov> findAllMovSensors();

    @Query("SELECT s FROM SensorAcceso s")
    List<SensorAcceso> findAllAccesoSensors();

    List<Sensor> findByEstado(boolean b);
}
