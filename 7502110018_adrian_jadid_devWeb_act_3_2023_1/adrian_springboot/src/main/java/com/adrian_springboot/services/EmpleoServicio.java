package com.adrian_springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adrian_springboot.modelo.Empleo;
import com.adrian_springboot.repositorio.EmpleoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleoServicio {
    private final EmpleoRepositorio empleoRepositorio;

    @Autowired
    public EmpleoServicio(EmpleoRepositorio empleoRepositorio) {
        this.empleoRepositorio = empleoRepositorio;
    }

    public List<Empleo> listarEmpleos() {
        return empleoRepositorio.findAll();
    }

    public Optional<Empleo> obtenerEmpleoPorId(int id) {
        return empleoRepositorio.findById(id);
    }

    public void agregarEmpleo(Empleo empleo) {
        empleoRepositorio.save(empleo);
    }

    public void actualizarEmpleo(Empleo empleo) {
        empleoRepositorio.save(empleo);
    }

    public void eliminarEmpleo(int id) {
        empleoRepositorio.deleteById(id);
    }
}


