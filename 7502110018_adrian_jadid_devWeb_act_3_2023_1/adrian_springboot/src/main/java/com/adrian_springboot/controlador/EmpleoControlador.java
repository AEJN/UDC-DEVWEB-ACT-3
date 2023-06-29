package com.adrian_springboot.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.adrian_springboot.modelo.Empleo;
import com.adrian_springboot.services.EmpleoServicio;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empleos")
public class EmpleoControlador {
    private final EmpleoServicio empleoServicio;

    @Autowired
    public EmpleoControlador(EmpleoServicio empleoServicio) {
        this.empleoServicio = empleoServicio;
    }

    @GetMapping("/listar")
    public String listarEmpleos(Model model) {
        List<Empleo> empleos = empleoServicio.listarEmpleos();
        model.addAttribute("empleos", empleos);
        return "empleo/listar";
    }

    @GetMapping("/agregar")
    public String mostrarPaginaoAgregar(Model model) {
        Empleo empleo = new Empleo();
        model.addAttribute("empleo", empleo);
        return "empleo/agregar";
    }

    @PostMapping("/agregar")
    public String agregarEmpleo(@ModelAttribute("empleo") Empleo empleo) {
        empleoServicio.agregarEmpleo(empleo);
        return "redirect:/empleos/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarPaginaEditar(@PathVariable("id") int id, Model model) {
        Optional<Empleo> empleo = empleoServicio.obtenerEmpleoPorId(id);
        if (empleo.isPresent()) {
            model.addAttribute("empleo", empleo.get());
            return "empleo/editar";
        }
        return "redirect:/empleos/listar";
    }

    @PostMapping("/editar")
    public String editarEmpleo(@ModelAttribute("empleo") Empleo empleo) {
        empleoServicio.actualizarEmpleo(empleo);
        return "redirect:/empleos/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleo(@PathVariable("id") int id) {
        empleoServicio.eliminarEmpleo(id);
        return "redirect:/empleos/listar";
    }
}

