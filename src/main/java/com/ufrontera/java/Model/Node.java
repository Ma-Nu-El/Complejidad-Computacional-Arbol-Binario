package com.ufrontera.java.Model;

public class Node {
    public Palabra palabra; // Significado de la palabra
    public Node hijoIzquierdo; // Nodo hijo izquierdo
    public Node hijoDerecho; // Nodo hijo derecho

    public void setPalabra(Palabra palabra) {
        this.palabra = palabra;
    }

    public Palabra getPalabra() {
        return palabra;
    }

}
