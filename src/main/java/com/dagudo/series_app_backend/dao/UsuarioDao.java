package com.dagudo.series_app_backend.dao;

import com.dagudo.series_app_backend.model.Usuario;

import java.util.ArrayList;

public interface UsuarioDao {
    public Usuario getUsuarioByName(String user);
    public Usuario postUsuario(Usuario usuario);
    public ArrayList<Usuario> getAllUsuarios();
}
