package com.dagudo.series_app_backend.dao.daoImpl;

import com.dagudo.series_app_backend.dao.AdministradorConexiones;
import com.dagudo.series_app_backend.dao.UsuarioSerieDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioSerieDaoImpl implements UsuarioSerieDao {
    @Override
    public String crearRelacion(Integer id_usuario, Integer id_serie, Integer temp_actual, Integer episod_actual, Integer id_plataforma) {

        try {
            Connection connection = AdministradorConexiones.getInstance();
            String sql = "INSERT INTO usuario_serie (id_usuario, id_serie, temp_actual, episod_actual, id_plataforma) VALUES (?,?,?,?,?)";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id_usuario);
            stmt.setInt(2, id_serie);
            stmt.setInt(3, temp_actual);
            stmt.setInt(4, episod_actual);
            stmt.setInt(5, id_plataforma);
            stmt.execute();

            stmt.close();
            return "OK";

        }catch (SQLException sqle) {
            System.out.println(sqle);
        }catch (Exception e) {
            System.out.println(e);
        }
        return "NOT OK";
    }
}
