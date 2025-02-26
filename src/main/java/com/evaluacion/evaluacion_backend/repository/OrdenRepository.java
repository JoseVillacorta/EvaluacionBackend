package com.evaluacion.evaluacion_backend.repository;

import com.evaluacion.evaluacion_backend.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
