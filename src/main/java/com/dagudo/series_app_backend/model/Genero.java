package com.dagudo.series_app_backend.model;

public class Genero {

    private Integer id_genero;
    private String genero;

    public Genero() {
    }

    public Genero(String genero) {
        this.genero = genero;
    }

    public Genero(Integer id_genero, String genero) {
        this.id_genero = id_genero;
        this.genero = genero;
    }

    public Integer getId_genero() {
        return id_genero;
    }

    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
