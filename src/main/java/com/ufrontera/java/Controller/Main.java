package com.ufrontera.java.Controller;

import com.ufrontera.java.Model.*;

/**
 * apellido1-nombre1_apellido2-nombre2
 *
 * [2021-11-23 Mar]
 * Authores: hijerra-camilo_sepulveda-jose_fuica-morales-manuel
 *           Hijerra Camilo
 *           Sepulveda Jose
 *           Fuica Morales Manuel
 */

public class Main {
    public static void main(String[] args) {
        String hline = "-------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("EVALUACIÓN 2:");
        System.out.println(hline);

        App aplicacion = new App();
        /*EN ESTE CODGO INVOCAMOS EL METODO AGREGAR PALABRA*/
        aplicacion.agregarPalabras();
        System.out.println(hline);

         /*EN ESTE CODGO INVOCAMOS EL METODO MOSTRAR PALABRA*/
        aplicacion.mostrarPalabras();
        System.out.println(hline);

         /*EN ESTE CODGO INVOCAMOS EL METODO BUSCAR PALABRA*/
        aplicacion.buscarPalabra();
        System.out.println(hline);

         /*EN ESTE CODGO INVOCAMOS EL METODO ELIMINAR PALABRA*/
        aplicacion.eliminarPalabra();
        System.out.println(hline);

         /*EN ESTE CODGO INVOCAMOS EL METODO MOSTRAR PALABRA*/
        aplicacion.mostrarPalabras();
        System.out.println(hline);

        System.out.println(hline);
        System.out.println("Fin.");
    }
}
