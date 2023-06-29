package com.adrian_springboot.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adrian_springboot.modelo.Usuario;
import com.adrian_springboot.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {
    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorCC(int cc) {
        return usuarioRepositorio.findById(cc);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    public void eliminarUsuario(int cc) {
        usuarioRepositorio.deleteById(cc);
    }
    
    public boolean autenticarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(usuario.getCc());
        return usuarioOptional.isPresent() && usuarioOptional.get().getPass().equals(usuario.getPass());
    }
}

