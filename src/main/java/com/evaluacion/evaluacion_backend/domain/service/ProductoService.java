package com.evaluacion.evaluacion_backend.domain.service;

import com.evaluacion.evaluacion_backend.domain.entity.Productos;
import java.util.List;

public interface ProductoService {
    public List<Productos> findAll();
    public Productos save (Productos productos);
    public Productos findById(Long id);
    public void delete(Productos productos);
}
