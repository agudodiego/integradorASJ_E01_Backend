package com.dagudo.series_app_backend.service.serviceImpl;

import com.dagudo.series_app_backend.dao.daoImpl.GeneroDaoImpl;
import com.dagudo.series_app_backend.dao.daoImpl.PlataformaDaoImpl;
import com.dagudo.series_app_backend.dao.daoImpl.SerieDaoImpl;
import com.dagudo.series_app_backend.dao.daoImpl.UsuarioDaoImpl;
import com.dagudo.series_app_backend.model.Plataforma;
import com.dagudo.series_app_backend.model.Serie;
import com.dagudo.series_app_backend.model.Usuario;
import com.dagudo.series_app_backend.service.UsuarioService;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.Collection;

@Named
public class UsuarioServiceImpl implements UsuarioService {

    UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
    SerieDaoImpl serieDaoImpl = new SerieDaoImpl();
    PlataformaDaoImpl plataformaDaoImpl = new PlataformaDaoImpl();
    GeneroDaoImpl generoDaoImpl = new GeneroDaoImpl();

    @Override
    public Usuario traerUsuarioCompletoPorNombre(String user) {

        Usuario usuario = usuarioDaoImpl.getUsuarioByName(user);

        if ( usuario.getId_usuario() != null) {
            Collection<Serie> listadoSeries = serieDaoImpl.getSeriesByUsuario(usuario.getId_usuario());
            ArrayList<Serie> listadoSeriesAux = new ArrayList<>();

            for (Serie s: listadoSeries) {
                if (s.getActiva()) {
                    Plataforma p = plataformaDaoImpl.getPlataformaById(s.getPlataforma().getId_plataforma());
                    s.setPlataforma(p);
                    Collection<String> listadoGeneros = generoDaoImpl.getGeneroBySerie(s.getId_serie());
                    s.setGenero(listadoGeneros);
                    listadoSeriesAux.add(s);
                }
            }
            usuario.setSeries(listadoSeriesAux);
            return usuario;

        } else {
            Usuario u = null;
            return u;
        }
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        Usuario u = usuarioDaoImpl.postUsuario(usuario);
        return u;
    }

    @Override
    public Usuario chequearLogin(Usuario usuario) {
        ArrayList<Usuario> listaUsuarios = usuarioDaoImpl.getAllUsuarios();
        Usuario us = null;

        for (Usuario u : listaUsuarios) {
            if ( (usuario.getUsuario().equals(u.getUsuario())) && (usuario.getContrasenia().equals(u.getContrasenia())) ) {
                return this.traerUsuarioCompletoPorNombre(u.getUsuario());
            }
        }
        return us;
    }
}
