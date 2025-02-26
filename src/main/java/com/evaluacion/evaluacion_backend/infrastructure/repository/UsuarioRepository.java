package com.evaluacion.evaluacion_backend.infrastructure.repository;

import com.evaluacion.evaluacion_backend.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
