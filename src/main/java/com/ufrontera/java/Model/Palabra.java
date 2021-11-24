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
        //System.out.println("Nombre: " + nombre + " | Significado " + significado + " | Clasificación: " + clasificacion);
        /** TODO: Hacer que la impresión sea homogénea?
         *
         *  La impresion queda desordenada cuando se le agregan palabras muy
         *  largas, como 'escribir' o 'aplaudir'.
         *  Se le agregaron tabs --- '\t' --- pero soluciona parcialmente
         *  el problema.
         *
         */
        System.out.println(nombre + "\t\t | Significado: " + significado + "\t | Clasificación: " + clasificacion);
    }

    // Getters and setters
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
