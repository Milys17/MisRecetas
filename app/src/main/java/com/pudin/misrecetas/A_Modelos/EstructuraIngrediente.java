package com.pudin.misrecetas.A_Modelos;

public class EstructuraIngrediente {
    String nombre;
    int unidad;

    public EstructuraIngrediente(String nombre,int unidad){
        this.nombre = nombre;
        this.unidad = unidad;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }
}
