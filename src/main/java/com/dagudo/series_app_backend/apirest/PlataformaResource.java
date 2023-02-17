package com.dagudo.series_app_backend.apirest;

import com.dagudo.series_app_backend.model.Plataforma;
import com.dagudo.series_app_backend.service.serviceImpl.PlataformaServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;
import java.util.Collection;

@Path("/plataformas")
public class PlataformaResource {

    @Inject
    private PlataformaServiceImpl plataformaServiceImpl;
//    private PlataformaServiceImpl plataformaServiceImpl = new PlataformaServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlataformas() {
        Collection<Plataforma> listadoPlataformas = plataformaServiceImpl.getAllPlataformas();
        return Response.ok().status(Response.Status.OK).entity(listadoPlataformas).build();
    }
}
