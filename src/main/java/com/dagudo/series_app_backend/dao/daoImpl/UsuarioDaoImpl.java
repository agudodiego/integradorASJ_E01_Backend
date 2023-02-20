package com.dagudo.series_app_backend.dao.daoImpl;

import com.dagudo.series_app_backend.dao.AdministradorConexiones;
import com.dagudo.series_app_backend.dao.UsuarioDao;
import com.dagudo.series_app_backend.model.Serie;
import com.dagudo.series_app_backend.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDaoImpl implements UsuarioDao {
    @Override
    public Usuario getUsuarioByName(String user) {
        Usuario usuario = new Usuario();
        ArrayList<Serie> series = new ArrayList<>();

        try {
            Connection connection = AdministradorConexiones.getInstance();
            String sql = "SELECT * FROM usuario WHERE usuario = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario.setId_usuario(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setContrasenia(rs.getString(3));
                usuario.setEmail(rs.getString(4));
                usuario.setSeries(null);
            }

            stmt.close();

        }catch (SQLException sqle) {
            System.out.println(sqle);
        }catch (Exception e) {
            System.out.println(e);
        }

        return usuario;
    }

    @Override
    public Usuario postUsuario(Usuario usuario) {

        Usuario u = null;
        try {
            Connection connection = AdministradorConexiones.getInstance();
            String sql = "INSERT INTO usuario (usuario, contrasenia, email) VALUES (?,?,?)";

            PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContrasenia());
            stmt.setString(3, usuario.getEmail());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                Integer pk = rs.getInt(1);
                usuario.setId_usuario(pk);
            }

            stmt.close();
            return usuario;

        }catch (SQLException sqle) {
            System.out.println(sqle);
        }catch (Exception e) {
            System.out.println(e);
        }

        return u;
    }

    @Override
    public ArrayList<Usuario> getAllUsuarios() {

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try {
            Connection connection = AdministradorConexiones.getInstance();
            String sql = "SELECT * FROM usuario";

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setContrasenia(rs.getString("contrasenia"));
                u.setEmail(rs.getString("email"));
                listaUsuarios.add(u);
            }

            stmt.close();

        }catch (SQLException sqle) {
            System.out.println(sqle);
        }catch (Exception e) {
            System.out.println(e);
        }
        return listaUsuarios;
    }
}
