package com.dagudo.series_app_backend.apirest;

import com.dagudo.series_app_backend.model.Usuario;
import com.dagudo.series_app_backend.service.serviceImpl.UsuarioServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioResource {

    @Inject
    private UsuarioServiceImpl usuarioServiceImpl;

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
        return Response.ok().status(Response.Status.CREATED).entity(usuario).build();
    }
}
