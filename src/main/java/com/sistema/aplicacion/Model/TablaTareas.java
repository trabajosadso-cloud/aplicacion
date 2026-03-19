package com.sistema.aplicacion.Model;

public class TablaTareas {
    
    private int idTarea;
    private String descripcion;
    private String estado;
    
    // Estas son las llaves foráneas en el código de la base de datos
    private int idProyecto; 
    private int idResponsable;

    public TablaTareas() {
    }

    public TablaTareas(int idTarea, String descripcion, String estado, int idProyecto, int idResponsable) {
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.estado = estado;
        this.idProyecto = idProyecto;
        this.idResponsable = idResponsable;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }
      
}
