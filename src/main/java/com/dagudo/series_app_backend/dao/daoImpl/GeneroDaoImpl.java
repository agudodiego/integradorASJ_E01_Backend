package com.dagudo.series_app_backend.dao.daoImpl;

import com.dagudo.series_app_backend.dao.AdministradorConexiones;
import com.dagudo.series_app_backend.dao.GeneroDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class GeneroDaoImpl implements GeneroDao {
    @Override
    public Collection<String> getGeneroBySerie(Integer idSerie) {

        ArrayList<String> listadoGeneros = new ArrayList<>();

        try {
            Connection connection = AdministradorConexiones.getInstance();
            String sql = "SELECT * FROM genero_serie INNER JOIN genero ON genero.id_genero = genero_serie.id_genero WHERE genero_serie.id_serie = ?;";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idSerie);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                listadoGeneros.add(rs.getString("genero"));
            }

            stmt.close();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        }

        return listadoGeneros;
    }
}
