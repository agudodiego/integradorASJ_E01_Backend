package com.dagudo.series_app_backend.service.serviceImpl;

import com.dagudo.series_app_backend.dao.daoImpl.PlataformaDaoImpl;
import com.dagudo.series_app_backend.model.Plataforma;
import com.dagudo.series_app_backend.service.PlataformaService;
import jakarta.inject.Named;

import java.util.Collection;
@Named
public class PlataformaServiceImpl implements PlataformaService {

    PlataformaDaoImpl plataformaDaoImpl = new PlataformaDaoImpl();
    @Override
    public Collection<Plataforma> getAllPlataformas() {
        Collection<Plataforma> plataformas = plataformaDaoImpl.getAllPlataformas();
        return plataformas;
    }
}
