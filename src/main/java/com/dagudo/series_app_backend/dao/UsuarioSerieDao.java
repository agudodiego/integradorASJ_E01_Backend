package com.dagudo.series_app_backend.dao;

public interface UsuarioSerieDao {
    public String createRelacion(Integer id_usuario, Integer id_serie, Integer temp_actual, Integer episod_actual, Integer id_plataforma, boolean activa);
    public String updateRelacion(Integer id_usuario, Integer id_serie, Integer temp_actual, Integer episod_actual, Integer id_plataforma, boolean activa);
}
