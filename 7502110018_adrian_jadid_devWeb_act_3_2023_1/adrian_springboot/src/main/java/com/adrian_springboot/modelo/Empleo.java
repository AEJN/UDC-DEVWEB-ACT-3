package com.adrian_springboot.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "empleos")
public class Empleo {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "areaTrabajo", nullable = false)
    private String areaTrabajo;

    @Column(name = "empresa", nullable = false)
    private String empresa;

    @Column(name = "nivel", nullable = false)
    private String nivel;

    @Column(name = "sueldo", nullable = false)
    private double sueldo;

    @Column(name = "funciones", nullable = false)
    private String funciones;

    @Column(name = "cargoJefe", nullable = false)
    private String cargoJefe;

    @Column(name = "cc_usuario", nullable = false)
    private int ccUsuario;

    public Empleo() {
    }

    public Empleo(int id, String nombre, String categoria, String areaTrabajo, String empresa, String nivel, double sueldo, String funciones, String cargoJefe, int ccUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.areaTrabajo = areaTrabajo;
        this.empresa = empresa;
        this.nivel = nivel;
        this.sueldo = sueldo;
        this.funciones = funciones;
        this.cargoJefe = cargoJefe;
        this.ccUsuario = ccUsuario;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public String getCargoJefe() {
        return cargoJefe;
    }

    public void setCargoJefe(String cargoJefe) {
        this.cargoJefe = cargoJefe;
    }

    public int getCcUsuario() {
        return ccUsuario;
    }

    public void setCcUsuario(int ccUsuario) {
        this.ccUsuario = ccUsuario;
    }
}


