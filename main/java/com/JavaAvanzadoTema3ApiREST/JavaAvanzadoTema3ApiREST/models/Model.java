package com.JavaAvanzadoTema3ApiREST.JavaAvanzadoTema3ApiREST.models;


// POJO -> Plain old java object
public class Model {
    private String nombre;
    private double valor;

    public Model(){}
    public Model(String nombre, double valor) {this.nombre = nombre; this.valor = valor;}
    public String getNombre() {return  nombre;}
    public  void setNombre(String nombre) {this.nombre = nombre;}
    public double getValor() {return valor;}
    public void setValor(double valor) {this.valor = valor;}
}
