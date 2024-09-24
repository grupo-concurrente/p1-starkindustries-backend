package com.starksecurity.backend.repositorios;

import com.starksecurity.backend.modelos.Lectura;
import com.starksecurity.backend.modelos.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioLectura extends JpaRepository<Lectura, Long> {

    // Buscar lecturas por sensor
    List<Lectura> findBySensor(Sensor sensor);

    // Obtener lecturas más recientes por sensor
    @Query("SELECT l FROM Lectura l WHERE l.sensor = ?1 ORDER BY l.fecha DESC")
    List<Lectura> findRecentLecturesBySensor(Sensor sensor);
}
