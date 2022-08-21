package com.JavaAvanzadoTema3ApiREST.JavaAvanzadoTema3ApiREST.services;


import com.JavaAvanzadoTema3ApiREST.JavaAvanzadoTema3ApiREST.models.Model;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@org.jvnet.hk2.annotations.Service
@Component
public class Service {
    private final List<Model> modelos = new ArrayList<Model>();

    public List<Model> getAll(){
        return modelos;
    }
    //curl localhost:8080/test
    public void add(Model modelo){
        modelos.add(modelo);
    }
    //curl -X POST localhost:8080/test -H "Content-Type: application/json" -d "{\"nombre\": \"juan\"}"

    public Model get(String nombre){
        for (Model modelo : modelos){
            if (modelo.getNombre().equalsIgnoreCase(nombre)){
                return modelo;
            }
        }
        return null;
    }
}
