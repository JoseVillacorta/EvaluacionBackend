package com.evaluacion.evaluacion_backend.application.services;

import com.evaluacion.evaluacion_backend.domain.entity.Productos;
import com.evaluacion.evaluacion_backend.infrastructure.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ProductoServiceImplementTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImplement productoService;

    private Productos producto;

    @BeforeEach
    void setUp(){
        producto = new Productos();
        producto.setId(1L);
        producto.setNombre_producto("Laptop");
    }

    @Test
    public void testFindAll() {
        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto));
        List<Productos> productos = productoService.findAll();

        assertFalse(productos.isEmpty());
        assertEquals(1, productos.size());
        assertEquals("Laptop", productos.get(0).getNombre_producto());
        verify(productoRepository, times(1)).findAll();
    }

    @Test
    void testSave() {
        when(productoRepository.save(any(Productos.class))).thenReturn(producto);

        Productos savedProducto = productoService.save(producto);

        assertNotNull(savedProducto);
        assertEquals("Laptop", savedProducto.getNombre_producto());
        verify(productoRepository, times(1)).save(any(Productos.class));
    }

    @Test
    void testFindById() {
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

        Productos foundProducto = productoService.findById(1L);

        assertNotNull(foundProducto);
        assertEquals("Laptop", foundProducto.getNombre_producto());
        verify(productoRepository, times(1)).findById(1L);
    }

    @Test
    void testDelete() {
        doNothing().when(productoRepository).delete(any(Productos.class));

        productoService.delete(producto);

        verify(productoRepository, times(1)).delete(producto);
    }


}