package com.evaluacion.evaluacion_backend.repository;

import com.evaluacion.evaluacion_backend.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Long> {
}
