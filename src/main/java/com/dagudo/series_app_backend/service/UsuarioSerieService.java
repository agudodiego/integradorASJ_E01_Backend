package com.dagudo.series_app_backend.service;

public interface UsuarioSerieService {
    public String crearRelacion(Integer id_usuario, Integer id_serie, Integer temp_actual, Integer episod_actual, Integer id_plataforma, boolean activa);
    public String actualizarRelacion(Integer id_usuario, Integer id_serie, Integer temp_actual, Integer episod_actual, Integer id_plataforma, boolean activa);
}
