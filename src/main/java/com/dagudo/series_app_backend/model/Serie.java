package com.dagudo.series_app_backend.model;

import java.util.Collection;

public class Serie {

    private Integer id_serie;
    private String titulo;
    private Integer temporadas;
    private Integer episodios;
    private String img_small;
    private String img_big;
    private String anio_lanzamiento;
    private String sitio_oficial;
    private String descripcion;
    private Integer temp_actual;
    private Integer episod_actual;
    private Collection<String> genero;
    private Plataforma plataforma;
    private boolean activa;


    public Serie() {
    }

    public Serie(String titulo, Integer temporadas, Integer episodios, String img_small, String img_big, String anio_lanzamiento, String sitio_oficial, String descripcion, Integer temp_actual, Integer episod_actual, Collection<String> genero, Plataforma plataforma, boolean activa) {
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.episodios = episodios;
        this.img_small = img_small;
        this.img_big = img_big;
        this.anio_lanzamiento = anio_lanzamiento;
        this.sitio_oficial = sitio_oficial;
        this.descripcion = descripcion;
        this.temp_actual = temp_actual;
        this.episod_actual = episod_actual;
        this.genero = genero;
        this.plataforma = plataforma;
        this.activa = activa;
    }

    public Serie(Integer id_serie, String titulo, Integer temporadas, Integer episodios, String img_small, String img_big, String anio_lanzamiento, String sitio_oficial, String descripcion, Integer temp_actual, Integer episod_actual, Collection<String> genero, Plataforma plataforma, boolean activa) {
        this.id_serie = id_serie;
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.episodios = episodios;
        this.img_small = img_small;
        this.img_big = img_big;
        this.anio_lanzamiento = anio_lanzamiento;
        this.sitio_oficial = sitio_oficial;
        this.descripcion = descripcion;
        this.temp_actual = temp_actual;
        this.episod_actual = episod_actual;
        this.genero = genero;
        this.plataforma = plataforma;
        this.activa = activa;
    }

    public Integer getId_serie() {
        return id_serie;
    }

    public void setId_serie(Integer id_serie) {
        this.id_serie = id_serie;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }

    public Integer getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Integer episodios) {
        this.episodios = episodios;
    }

    public String getImg_small() {
        return img_small;
    }

    public void setImg_small(String img_small) {
        this.img_small = img_small;
    }

    public String getImg_big() {
        return img_big;
    }

    public void setImg_big(String img_big) {
        this.img_big = img_big;
    }

    public String getAnio_lanzamiento() {
        return anio_lanzamiento;
    }

    public void setAnio_lanzamiento(String anio_lanzamiento) {
        this.anio_lanzamiento = anio_lanzamiento;
    }

    public String getSitio_oficial() {
        return sitio_oficial;
    }

    public void setSitio_oficial(String sitio_oficial) {
        this.sitio_oficial = sitio_oficial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTemp_actual() {
        return temp_actual;
    }

    public void setTemp_actual(Integer temp_actual) {
        this.temp_actual = temp_actual;
    }

    public Integer getEpisod_actual() {
        return episod_actual;
    }

    public void setEpisod_actual(Integer episod_actual) {
        this.episod_actual = episod_actual;
    }

    public Collection<String> getGenero() {
        return genero;
    }

    public void setGenero(Collection<String> genero) {
        this.genero = genero;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
