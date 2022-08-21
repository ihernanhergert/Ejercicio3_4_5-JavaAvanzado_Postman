package com.JavaAvanzadoTema3ApiREST.JavaAvanzadoTema3ApiREST.controllers;


import com.JavaAvanzadoTema3ApiREST.JavaAvanzadoTema3ApiREST.models.Model;
import com.JavaAvanzadoTema3ApiREST.JavaAvanzadoTema3ApiREST.services.Service;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class Controller {
    private final Service theService;

    public Controller(Service theService) {
        this.theService = theService;
        this.theService.add(new Model("uno", Math.random()));
        this.theService.add(new Model("dos", Math.random()));
        this.theService.add(new Model("tres", Math.random()));
    }

    @GET
    @Path("/test")
    @Produces("application/json")
    public List<Model> listarModelos(){
        System.out.println("Se buscó todos los nombres");
        return  theService.getAll();
    }

    @GET
    @Path("/test/{nombre}")
    @Produces("application/json")
    public Model listarModelo(@PathParam("nombre") String nombre){
        System.out.println("Nombre Buscado" + nombre);
        return theService.get(nombre);
    }


    @POST
    @Path("/test")
    @Produces("application/json")
    @Consumes("application/json")

    public Response agregarModelo(Model modelo){
        theService.add(modelo);
        System.out.println("agregarModelo");
        return Response.created(
                URI.create("/test/" + modelo.getNombre())
        ).build();
    }
}
