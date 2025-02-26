package com.evaluacion.evaluacion_backend.services;

import com.evaluacion.evaluacion_backend.entity.Productos;
import java.util.List;

public interface ProductoService {
    public List<Productos> findAll();
    public Productos save (Productos productos);
    public Productos findById(Long id);
    public void delete(Productos productos);
}
