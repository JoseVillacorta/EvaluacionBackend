package com.evaluacion.evaluacion_backend.controller;


import com.evaluacion.evaluacion_backend.entity.Productos;
import com.evaluacion.evaluacion_backend.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductosController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(value = "/productos")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<>();
        try {
            List<Productos> list = productoService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/productos/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            Productos data = productoService.findById(id);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        }
        catch (Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/productos")
    public ResponseEntity<Object> create(@RequestBody Productos productos){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Productos res = productoService.save(productos);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Object> update(@RequestBody Productos productos, @PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Productos currectProductos = productoService.findById(id);

            currectProductos.setNombre_producto(productos.getNombre_producto());
            currectProductos.setDescripcion(productos.getDescripcion());

            Productos res = productoService.save(productos);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Productos currectProductos = productoService.findById(id);
            productoService.delete(currectProductos);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
        catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
