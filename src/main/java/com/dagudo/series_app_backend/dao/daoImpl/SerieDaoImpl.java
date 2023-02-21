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
                s.setActiva(rs.getBoolean("activa"));

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

    @Override
    public Serie createSerie(Serie s) {

        Serie serie = null;
        try {
            Connection connection = AdministradorConexiones.getInstance();
            String sql = "INSERT INTO serie (id_serie, titulo, temporadas, episodios, img_small, img_big, fecha_lanzamiento, sitio_oficial, descripcion) VALUES (?,?,?,?,?,?,?,?,?)";
            // aca quizs tenga que traerme las series de la base y chequearlas para ver que no este repetida

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, s.getId_serie());
            stmt.setString(2, s.getTitulo());
            stmt.setInt(3, s.getTemporadas());
            stmt.setInt(4, s.getEpisodios());
            stmt.setString(5, s.getImg_small());
            stmt.setString(6, s.getImg_big());
            stmt.setString(7, s.getAnio_lanzamiento());
            stmt.setString(8, s.getSitio_oficial());
            stmt.setString(9, s.getDescripcion());
            stmt.execute();

            stmt.close();
            return s;

        }catch (SQLException sqle) {
            System.out.println(sqle);
        }catch (Exception e) {
            System.out.println(e);
        }
        return serie;
    }
}
