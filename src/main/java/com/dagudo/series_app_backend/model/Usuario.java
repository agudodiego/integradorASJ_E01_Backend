package com.dagudo.series_app_backend.model;

import java.util.Collection;

public class Usuario {

    private Integer id_usuario;
    private String usuario;
    private String contrasenia;
    private String email;
    private Collection<Serie> series;

    public Usuario() {
    }

    public Usuario(String usuario, String contrasenia, String email, Collection<Serie> series) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.email = email;
        this.series = series;
    }

    public Usuario(Integer id_usuario, String usuario, String contrasenia, String email, Collection<Serie> series) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.email = email;
        this.series = series;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Serie> getSeries() {
        return series;
    }

    public void setSeries(Collection<Serie> series) {
        this.series = series;
    }
}
