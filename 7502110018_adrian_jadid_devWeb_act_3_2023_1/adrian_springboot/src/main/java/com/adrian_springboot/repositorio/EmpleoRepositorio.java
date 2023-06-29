package com.adrian_springboot.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adrian_springboot.modelo.Empleo;

public interface EmpleoRepositorio extends JpaRepository<Empleo, Integer> {
}
