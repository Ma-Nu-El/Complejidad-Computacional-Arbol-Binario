package com.ufrontera.java.Model;

public class App {

        // Creamos el arbol donde se almacenaran las palabras
        Tree palabras = new Tree();

        public void mostrarPalabras() {
                System.out.println("-Palabras agregadas al diccionario:");
                palabras.ordenar();
        }

        public void agregarPalabras() {

                // Nótese que están desordenadas
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
        }

        public void buscarPalabra() {
                System.out.println("-Palabra buscada:");
                palabras.find("Saltar").mostrarPalabra();
        }

        public void eliminarPalabra() {
                System.out.println("-Eliminar palabra:");
                palabras.eliminar("Saltar");
        }

        public void ordenarPalabras() {
                System.out.println("-Ordenar:");
                palabras.ordenar();
        }
}
