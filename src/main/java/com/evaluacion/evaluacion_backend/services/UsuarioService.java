package com.evaluacion.evaluacion_backend.services;

import com.evaluacion.evaluacion_backend.entity.Usuario;

import java.util.List;


public interface UsuarioService {

    public List<Usuario> findAll();

    public Usuario save(Usuario usuario);

    public Usuario findById(Long id);

    public void delete(Usuario usuario);
}
