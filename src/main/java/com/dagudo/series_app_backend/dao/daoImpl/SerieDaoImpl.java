package com.dagudo.series_app_backend.dao.daoImpl;

import com.dagudo.series_app_backend.dao.AdministradorConexiones;
import com.dagudo.series_app_backend.dao.SerieDao;
import com.dagudo.series_app_backend.model.Plataforma;
import com.dagudo.series_app_backend.model.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class SerieDaoImpl implements SerieDao {
    @Override
    public Collection<Serie> getSeriesByUsuario(Integer id) {

        ArrayList<Serie> listadoSeries = new ArrayList<>();

        try {

            Connection connection = AdministradorConexiones.getInstance();
            String sql = "SELECT * FROM usuario_serie INNER JOIN serie ON serie.id_serie = usuario_serie.id_serie WHERE id_usuario = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Serie s = new Serie();
                Plataforma p = new Plataforma();
                s.setId_serie(rs.getInt("id_serie"));
                s.setTitulo(rs.getString("titulo"));
                s.setTemporadas(rs.getInt("temporadas"));
                s.setTemp_actual(rs.getInt("temp_actual"));
                s.setEpisodios(rs.getInt("episodios"));
                s.setEpisod_actual(rs.getInt("episod_actual"));
                s.setImg_small(rs.getString("img_small"));
                s.setImg_big(rs.getString("img_big"));
                s.setAnio_lanzamiento(rs.getString("fecha_lanzamiento"));
                s.setSitio_oficial(rs.getString("sitio_oficial"));
                s.setDescripcion(rs.getString("descripcion"));

                // seteo el id de la plataforma
                p.setId_plataforma(rs.getInt("id_plataforma"));
                s.setPlataforma(p);

                listadoSeries.add(s);
            }

            stmt.close();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        }

        return listadoSeries;
    }
}
