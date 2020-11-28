package com.example.mascotasapplication.DataSet;

import java.io.Serializable;

public class Mascotas implements Serializable {

    private String nombre, descripcion,edad, numerohueso;
    private int foto;
    private boolean favorito;

    public Mascotas(){

    }

    public Mascotas (int foto, String numerohueso){
        this.foto=foto;
        this.numerohueso  = numerohueso;

    }
    public Mascotas(int foto, String nombre, String numerohueso, String descripcion, String edad ) {
        this.foto = foto;
        this.nombre = nombre;
        this.numerohueso = numerohueso;
        this.descripcion = descripcion;
        this.edad = edad;


    }


    public boolean isFavorito() {
        return favorito;
    }
    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumerohueso() {
        return numerohueso;
    }

    public void setNumerohueso(String numerohueso) {
        this.numerohueso = numerohueso;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad() {
        this.edad = edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }


}
