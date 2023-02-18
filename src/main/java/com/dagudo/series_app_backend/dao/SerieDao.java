package com.dagudo.series_app_backend.dao;

import com.dagudo.series_app_backend.model.Serie;

import java.util.Collection;

public interface SerieDao {

    public Collection<Serie> getSeriesByUsuario(Integer id);
}
