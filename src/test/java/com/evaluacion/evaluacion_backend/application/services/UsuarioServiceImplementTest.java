package com.evaluacion.evaluacion_backend.application.services;

import com.evaluacion.evaluacion_backend.domain.entity.Usuario;
import com.evaluacion.evaluacion_backend.infrastructure.repository.UsuarioRepository;
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
class UsuarioServiceImplementTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImplement usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp(){
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Jose Fernando");
        usuario.setCorreo("josef@gmail.com");
    }

    @Test
    public void testFindAll() {
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario));

        List<Usuario> usuarios = usuarioService.findAll();

        assertFalse(usuarios.isEmpty());
        assertEquals(1, usuarios.size());
        assertEquals("Jose Fernando", usuarios.get(0).getNombre());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void testSave() {
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario savedUsuario = usuarioService.save(usuario);

        assertNotNull(savedUsuario);
        assertEquals("Jose Fernando", savedUsuario.getNombre());
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

    @Test
    void testFindById() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario foundUsuario = usuarioService.findById(1L);

        assertNotNull(foundUsuario);
        assertEquals("Jose Fernando", foundUsuario.getNombre());
        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    void testDelete() {
        doNothing().when(usuarioRepository).delete(any(Usuario.class));

        usuarioService.delete(usuario);

        verify(usuarioRepository, times(1)).delete(usuario);
    }

}