package com.dagudo.series_app_backend.model;

public class Plataforma {

    private Integer id_plataforma;
    private String plataforma;
    private String url;

    public Plataforma() {
    }

    public Plataforma(String plataforma, String url) {
        this.plataforma = plataforma;
        this.url = url;
    }

    public Plataforma(Integer id_plataforma, String plataforma, String url) {
        this.id_plataforma = id_plataforma;
        this.plataforma = plataforma;
        this.url = url;
    }

    public Integer getId_plataforma() {
        return id_plataforma;
    }

    public void setId_plataforma(Integer id_plataforma) {
        this.id_plataforma = id_plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "id_plataforma=" + id_plataforma +
                ", plataforma='" + plataforma + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
