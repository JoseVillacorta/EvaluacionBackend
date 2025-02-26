package com.evaluacion.evaluacion_backend.services;

import com.evaluacion.evaluacion_backend.entity.Productos;
import com.evaluacion.evaluacion_backend.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImplement implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    @Transactional
    public List<Productos> findAll() {
        return (List<Productos>) productoRepository.findAll();
    }

    @Override
    @Transactional
    public Productos save(Productos productos) {
        return productoRepository.save(productos);
    }

    @Override
    @Transactional
    public Productos findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Productos productos) {
        productoRepository.delete(productos);
    }
}
