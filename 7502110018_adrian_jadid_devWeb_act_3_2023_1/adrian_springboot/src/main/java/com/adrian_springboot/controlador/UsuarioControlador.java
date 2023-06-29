package com.adrian_springboot.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.adrian_springboot.modelo.Usuario;
import com.adrian_springboot.services.UsuarioServicio;

import jakarta.servlet.http.HttpSession;

import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {
    private final UsuarioServicio usuarioServicio;

    @Autowired
    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
        return "Usuario/listar";
    }

    @GetMapping("/registrar")
    public String mostrarPaginaRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Usuario/registrar";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioServicio.registrarUsuario(usuario);
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/editar/{cc}")
    public String mostrarPaginaEdicion(@PathVariable int cc, Model model) {
        Optional<Usuario> usuario = usuarioServicio.obtenerUsuarioPorCC(cc);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "Usuario/editar";
        }
        return "redirect:/usuarios/listar";
    }

    @PostMapping("/editar")
    public String actualizarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioServicio.actualizarUsuario(usuario);
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/eliminar/{cc}")
    public String eliminarUsuario(@PathVariable int cc) {
        usuarioServicio.eliminarUsuario(cc);
        return "redirect:/usuarios/listar";
    }
    
    @GetMapping("/login")
    public String mostrarPaginaLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Usuario/login";
    }

    @PostMapping("/login")
    public String loginUsuario(@ModelAttribute("usuario") Usuario usuario, HttpSession session) {
        if (usuarioServicio.autenticarUsuario(usuario)) {
            session.setAttribute("usuario", usuario);
            return "redirect:/usuarios/listar";
        } else {
            return "redirect:/usuarios/login?error";
        }
    }

    @GetMapping("/logout")
    public String logoutUsuario(HttpSession session) {
        session.invalidate();
        return "redirect:/usuarios/login";
    }
}

