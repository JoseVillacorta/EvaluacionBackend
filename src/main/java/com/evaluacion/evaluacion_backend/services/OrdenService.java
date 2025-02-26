package com.evaluacion.evaluacion_backend.services;

import com.evaluacion.evaluacion_backend.entity.Orden;
import java.util.List;

public interface OrdenService {
    public List<Orden> findAll();
    public Orden save (Orden orden);
    public Orden findById(Long id);
    public void delete(Orden orden);
}
