package com.dagudo.series_app_backend.service.serviceImpl;

import com.dagudo.series_app_backend.dao.daoImpl.SerieDaoImpl;
import com.dagudo.series_app_backend.model.Serie;
import com.dagudo.series_app_backend.service.SerieService;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.Collection;
@Named
public class SerieServiceImpl implements SerieService {

    private SerieDaoImpl serieDaoImpl = new SerieDaoImpl();

    @Override
    public Collection<Serie> getSeriesByUsuario(Integer id) {
        Collection<Serie> listadoSeries = serieDaoImpl.getSeriesByUsuario(id);
        return listadoSeries;
    }

    @Override
    public Serie crearSerie(Serie s) {
        Serie serie = serieDaoImpl.createSerie(s);
        return serie;
    }
}
