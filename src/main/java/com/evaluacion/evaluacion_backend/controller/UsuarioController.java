package com.evaluacion.evaluacion_backend.controller;


import com.evaluacion.evaluacion_backend.entity.Usuario;
import com.evaluacion.evaluacion_backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/usuarios")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            List<Usuario> list = usuarioService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/usuarios/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            Usuario data = usuarioService.findById(id);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        }
        catch (Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/usuarios")
    public ResponseEntity<Object> create(@RequestBody Usuario usuario){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Usuario res = usuarioService.save(usuario);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Object> update(@RequestBody Usuario usuario, @PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Usuario currectUsuario = usuarioService.findById(id);

            currectUsuario.setNombre(usuario.getNombre());
            currectUsuario.setCorreo(usuario.getCorreo());

            Usuario res = usuarioService.save(usuario);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Usuario currentUsuario = usuarioService.findById(id);
            usuarioService.delete(currentUsuario);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
