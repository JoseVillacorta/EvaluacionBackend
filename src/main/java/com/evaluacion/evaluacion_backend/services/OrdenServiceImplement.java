package com.evaluacion.evaluacion_backend.services;

import com.evaluacion.evaluacion_backend.entity.Orden;
import com.evaluacion.evaluacion_backend.repository.OrdenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServiceImplement implements OrdenService{

    @Autowired
    private OrdenRepository ordenRepository;


    @Override
    @Transactional
    public List<Orden> findAll() {
        return (List<Orden>) ordenRepository.findAll();
    }

    @Override
    @Transactional
    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    @Transactional
    public Orden findById(Long id) {
        return ordenRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Orden orden) {
        ordenRepository.delete(orden);
    }
}
