package com.dagudo.series_app_backend.apirest;

import com.dagudo.series_app_backend.model.Mensaje;
import com.dagudo.series_app_backend.model.Serie;
import com.dagudo.series_app_backend.model.Usuario;
import com.dagudo.series_app_backend.service.serviceImpl.SerieServiceImpl;
import com.dagudo.series_app_backend.service.serviceImpl.UsuarioSerieServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/serie")
public class SerieResource {

    @Inject
    private SerieServiceImpl serieServiceImpl;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarSerie(Serie s) {

        Serie serie = serieServiceImpl.crearSerie(s);

        if (serie != null) {
            Mensaje men = new Mensaje("Serie creada");
            return Response.ok().status(Response.Status.CREATED).entity(men).build();
        }
        Mensaje men = new Mensaje("La serie ya esta en la BD");
        return Response.ok().status(Response.Status.NOT_FOUND).entity(men).build();
    }
}
