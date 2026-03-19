package com.sistema.aplicacion.Model;

public class TablaResponsable {

    private int idResponsable;
    private String nombresCompleto;
    private String email;
    private String cargo;

    public TablaResponsable() {
    }

    public TablaResponsable(int idResponsable, String nombresCompleto, String email, String cargo) {
        this.idResponsable = idResponsable;
        this.nombresCompleto = nombresCompleto;
        this.email = email;
        this.cargo = cargo;
    }

    public int getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getNombresCompleto() {
        return nombresCompleto;
    }

    public void setNombresCompleto(String nombresCompleto) {
        this.nombresCompleto = nombresCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
  
    
}
