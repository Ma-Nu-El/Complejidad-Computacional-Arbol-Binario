package com.ufrontera.java.Controller;
import com.ufrontera.java.Model.Tree;

/**
* apellido1-nombre1_apellido2-nombre2
*
* [2021-11-23 Mar]
* Authores:  hijerra-camilo_sepulveda-jose_fuica-morales-manuel
*           Hijerra Camilo
*           Sepulveda Jose
*           Fuica Morales Manuel
*/

public class App {
    public static void main( String[] args ) {
        System.out.println("EVALUACIÓN 2:");
        System.out.println("");

        //creamos el arbol donde se almacenaran las palabras
        Tree palabras = new Tree();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        palabras.agregar("Saltar", "Elevarse del suelo u otra superficie con impulso para caer en el mismo lugar o en otro.", "Verbo");
        palabras.agregar("Volar", "Moverse por el aire usando alas o un medio artificial.", "Verbo");
        palabras.agregar("Caminar", "Andar de un lugar a otro usando las piernas", "Verbo");
        palabras.agregar("Comer", "Tomar alimento por la boca", "Verbo");
        palabras.agregar("Escribir", "Representar ideas, palabras, números o notas musicales mediante letras u otros signos gráficos.", "Verbo");
        palabras.agregar("Nacer", "Salir del vientre de la madre (o huevo).", "Verbo");
        palabras.agregar("Aplaudir", "Chocar repetidamente las palmas de las manos", "Verbo");
        palabras.agregar("Nadar", "Avanzar en el agua [una persona o un animal] haciendo los movimientos con las manos", "Verbo");
        palabras.agregar("Decir", "Articular, pronunciar o emitir los sonidos de una lengua.", "Verbo");
        palabras.agregar("Jugar", "Realizar una actividad o hacer una cosa, generalmente ejercitando alguna capacidad o destreza", "Verbo");
        palabras.agregar("Cantar", "Producir sonidos armoniosos o emitir su voz", "Verbo");
        palabras.agregar("Zarpar", "Trabajar con la zapa", "Verbo");
        palabras.agregar("Correr", "Desplazarse rápidamente", "Verbo");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("-Palabras agregadas al diccionario:");
        palabras.ordenar();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("-Palabra buscada:");
        palabras.find("Saltar").mostrarPalabra();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("-Eliminar palabra:");
        palabras.eliminar("Saltar");
        palabras.ordenar();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("-Ordenar:");
        palabras.ordenar();
    }
}
