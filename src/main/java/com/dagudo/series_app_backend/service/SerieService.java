package com.dagudo.series_app_backend.service;

import com.dagudo.series_app_backend.model.Serie;

import java.util.Collection;

public interface SerieService {
    public Collection<Serie> getSeriesByUsuario(Integer id);
}
