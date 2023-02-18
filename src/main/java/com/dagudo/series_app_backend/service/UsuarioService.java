package com.dagudo.series_app_backend.service;

import com.dagudo.series_app_backend.model.Usuario;

public interface UsuarioService {

    public Usuario traerUsuarioCompletoPorNombre(String user);
    public Usuario crearUsuario(Usuario usuario);
}
