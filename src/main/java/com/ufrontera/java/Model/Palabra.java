package com.ufrontera.java.Model;


public class Palabra {
    private String nombre;
    private String significado;
    private String clasificacion;

    public Palabra(String nombre, String significado, String clasificacion) {
        this.nombre = nombre;
        this.significado = significado;
        this.clasificacion = clasificacion;
    }

    public void mostrarPalabra() {
        System.out.println("Nombre: " + nombre + " | Significado " + significado + " | Clasificación: " + clasificacion);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
