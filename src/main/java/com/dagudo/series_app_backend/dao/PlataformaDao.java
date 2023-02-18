package com.dagudo.series_app_backend.dao;

import com.dagudo.series_app_backend.model.Plataforma;

import java.util.Collection;

public interface PlataformaDao {

    public Collection<Plataforma> getAllPlataformas();
    public Plataforma getPlataformaById(Integer id);
}
