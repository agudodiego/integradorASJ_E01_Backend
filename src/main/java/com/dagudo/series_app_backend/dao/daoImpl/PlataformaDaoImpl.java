package com.dagudo.series_app_backend.dao.daoImpl;

import com.dagudo.series_app_backend.dao.AdministradorConexiones;
import com.dagudo.series_app_backend.dao.PlataformaDao;
import com.dagudo.series_app_backend.model.Plataforma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class PlataformaDaoImpl implements PlataformaDao {
    @Override
    public Collection<Plataforma> getAllPlataformas() {
        ArrayList<Plataforma> plataformas = new ArrayList<>();

        try {
            Connection connection = AdministradorConexiones.getInstance();
            String sql = "SELECT * FROM plataforma";

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Plataforma pl = new Plataforma();
                pl.setId_plataforma(rs.getInt("id_plataforma"));
                pl.setPlataforma(rs.getString("plataforma"));
                pl.setUrl(rs.getString("url"));
                plataformas.add(pl);
            }

            stmt.close();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        }

        return plataformas;
    }

    @Override
    public Plataforma getPlataformaById(Integer id) {

        Plataforma plataforma = new Plataforma();

        try {
            Connection connection = AdministradorConexiones.getInstance();
            String sql = "SELECT * FROM plataforma WHERE id_plataforma = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                plataforma.setId_plataforma(rs.getInt("id_plataforma"));
                plataforma.setPlataforma(rs.getString("plataforma"));
                plataforma.setUrl(rs.getString("url"));
            }

            stmt.close();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        }

        return plataforma;
    }
}
