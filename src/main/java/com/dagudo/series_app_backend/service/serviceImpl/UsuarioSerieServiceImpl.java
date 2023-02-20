package com.dagudo.series_app_backend.service.serviceImpl;

import com.dagudo.series_app_backend.dao.daoImpl.UsuarioSerieDaoImpl;
import com.dagudo.series_app_backend.service.UsuarioSerieService;
import jakarta.inject.Named;

@Named
public class UsuarioSerieServiceImpl implements UsuarioSerieService {

    UsuarioSerieDaoImpl usuarioSerieDaoImpl = new UsuarioSerieDaoImpl();
    @Override
    public String crearRelacion(Integer id_usuario, Integer id_serie, Integer temp_actual, Integer episod_actual, Integer id_plataforma) {
        String msg = usuarioSerieDaoImpl.crearRelacion(id_usuario, id_serie, temp_actual, episod_actual, id_plataforma);
        return msg;
    }
}
