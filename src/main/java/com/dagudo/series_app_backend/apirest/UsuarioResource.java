package com.dagudo.series_app_backend.apirest;

import com.dagudo.series_app_backend.dao.AdministradorConexiones;
import com.dagudo.series_app_backend.model.Mensaje;
import com.dagudo.series_app_backend.model.Serie;
import com.dagudo.series_app_backend.model.Usuario;
import com.dagudo.series_app_backend.service.serviceImpl.UsuarioSerieServiceImpl;
import com.dagudo.series_app_backend.service.serviceImpl.UsuarioServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.SQLException;

@Path("/usuario")
public class UsuarioResource {

    @Inject
    private UsuarioServiceImpl usuarioServiceImpl;
    @Inject
    private UsuarioSerieServiceImpl usuarioSerieServiceImpl;

    @Path("/{user}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response traerUsuarioCompletoPorNombre(@PathParam("user") String user) {
        Usuario u = usuarioServiceImpl.traerUsuarioCompletoPorNombre(user);
        if (u != null) {
            return Response.ok().status(Response.Status.OK).entity(u).build();
        } else {
            return Response.ok().status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearUsuario(Usuario u) {
        Usuario usuario = usuarioServiceImpl.crearUsuario(u);
        if (usuario != null) {
            return Response.ok().status(Response.Status.CREATED).entity(usuario).build();
        }

        return Response.ok().status(Response.Status.NOT_FOUND).build();
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response chequearLogin(Usuario u) {

        Usuario usuario = usuarioServiceImpl.chequearLogin(u);

        if (usuario != null) {
            return Response.ok().status(Response.Status.CREATED).entity(usuario).build();
        }

        return Response.ok().status(Response.Status.NOT_FOUND).build();
    }

    @Path("/serie/{idUsuario}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearRelacion(@PathParam("idUsuario") Integer idUsuario, Serie s) {

        String msg = usuarioSerieServiceImpl.crearRelacion(idUsuario, s.getId_serie(), s.getTemp_actual(), s.getEpisod_actual(), s.getPlataforma().getId_plataforma());

        if (msg.equals("OK")) {
            Mensaje men = new Mensaje("Serie relacionada con el usuario");
            return Response.ok().status(Response.Status.CREATED).entity(men).build();
        }
        Mensaje men = new Mensaje("Hubo un problema");
        return Response.ok().status(Response.Status.NOT_FOUND).entity(men).build();
    }

//    Connection connection;
//
//    {
//        try {
//            connection = AdministradorConexiones.getInstance();
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
