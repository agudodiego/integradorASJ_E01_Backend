package com.dagudo.series_app_backend.service.serviceImpl;

import com.dagudo.series_app_backend.dao.daoImpl.SerieDaoImpl;
import com.dagudo.series_app_backend.dao.daoImpl.UsuarioSerieDaoImpl;
import com.dagudo.series_app_backend.model.Serie;
import com.dagudo.series_app_backend.service.UsuarioSerieService;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Named
public class UsuarioSerieServiceImpl implements UsuarioSerieService {

    UsuarioSerieDaoImpl usuarioSerieDaoImpl = new UsuarioSerieDaoImpl();
    SerieDaoImpl serieDaoImpl = new SerieDaoImpl();


    @Override
    public String crearRelacion(Integer id_usuario, Integer id_serie, Integer temp_actual, Integer episod_actual, Integer id_plataforma, boolean activa) {

        Serie serieEnBD = new Serie();
        boolean yaExiste = false;
        Collection<Serie> listaSeries = serieDaoImpl.getSeriesByUsuario(id_usuario);

        for (Serie s: listaSeries) {

            if (id_serie.equals(s.getId_serie())) {
                yaExiste = true;
                serieEnBD.setId_serie(s.getId_serie());
                serieEnBD.setTitulo(s.getTitulo());
                serieEnBD.setTemporadas(s.getTemporadas());
                serieEnBD.setEpisodios(s.getEpisodios());
                serieEnBD.setImg_small(s.getImg_small());
                serieEnBD.setImg_big(s.getImg_big());
                serieEnBD.setAnio_lanzamiento(s.getAnio_lanzamiento());
                serieEnBD.setSitio_oficial(s.getSitio_oficial());
                serieEnBD.setDescripcion(s.getDescripcion());
                serieEnBD.setTemp_actual(s.getTemp_actual());
                serieEnBD.setEpisod_actual(s.getEpisod_actual());
                serieEnBD.setGenero(s.getGenero());
                serieEnBD.setPlataforma(s.getPlataforma());
//                serieEnBD.setActiva(true); // ya la pone en true el metodo updateRelacion()
                break;
            }
        }

        if (yaExiste) {
            String msg = usuarioSerieDaoImpl.updateRelacion(id_usuario, serieEnBD.getId_serie(), serieEnBD.getTemp_actual(), serieEnBD.getEpisod_actual(), serieEnBD.getPlataforma().getId_plataforma(), true);
            return msg;
        }

        String msg = usuarioSerieDaoImpl.createRelacion(id_usuario, id_serie, temp_actual, episod_actual, id_plataforma, activa);
        return msg;

    }

    @Override
    public String actualizarRelacion(Integer id_usuario, Integer id_serie, Integer temp_actual, Integer episod_actual, Integer id_plataforma, boolean activa) {
        String msg = usuarioSerieDaoImpl.updateRelacion(id_usuario, id_serie, temp_actual, episod_actual, id_plataforma, activa);
        return msg;
    }
}
