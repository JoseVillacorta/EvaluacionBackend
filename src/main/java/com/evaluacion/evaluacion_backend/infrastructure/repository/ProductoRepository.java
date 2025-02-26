package com.evaluacion.evaluacion_backend.infrastructure.repository;

import com.evaluacion.evaluacion_backend.domain.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Long> {
}
