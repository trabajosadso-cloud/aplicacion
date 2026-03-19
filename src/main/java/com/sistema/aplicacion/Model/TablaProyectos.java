package com.sistema.aplicacion.Model;

import java.time.LocalDate;

public class TablaProyectos {
    
    // 1. Atributos (Iguales a los campos de tu tabla en MySQL)
    private int idProyecto;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;

    // 2. Constructor vacío 
    public TablaProyectos() {
    }

    // 3. Constructor con todos los datos
    public TablaProyectos(int idProyecto, String nombre, String descripcion, LocalDate fechaInicio) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
    }

    // 4. Getters y Setters
    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}