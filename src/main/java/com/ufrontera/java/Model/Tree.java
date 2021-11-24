package com.ufrontera.java.Model;

import java.util.ArrayList;

public class Tree {
    //Primer nodo del arbol
    private Node root;

    //Lista para almacenar los objetos del arbol
    private ArrayList<Palabra> palabras;

    //Constructor
    public Tree() {
        root = null;
    }

    // Encontrar el nodo que tenga la palabra dada
    public Palabra find(String nombre) {
        // Se define la ubicación actual en el primer nodo
        Node current = this.root;

        while (!current.palabra.getNombre().toLowerCase().equals(nombre.toLowerCase())) {

            if (irIzquierda(nombre.toLowerCase(), current.palabra.getNombre().toLowerCase())) {
                current = current.hijoIzquierdo;
            } else {
                current = current.hijoDerecho;
            }
            if (current == null) {
                return null;
            }
        }
        return current.palabra;
    } // Fin find()

    // Agregar un nodo que contenga la palabra, significado y clasificacion
    public void agregar(String nombre, String significado, String clasificacion) {
        Node newNode = new Node();
        newNode.palabra = new Palabra(nombre, significado, clasificacion);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;

                if (irIzquierda(nombre.toLowerCase(), current.palabra.getNombre().toLowerCase())) {
                    current = current.hijoIzquierdo;
                    if (current == null) {
                        parent.hijoIzquierdo = newNode;
                        return;
                    }
                } else {
                    current = current.hijoDerecho;
                    if (current == null) {
                        parent.hijoDerecho = newNode;
                        return;
                    }
                }
            }

        }
    } // Fin agregar()

    // Elimina el nodo que tenga la palabra dado por el usuario
    public boolean eliminar(String nombre) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (!current.palabra.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
            parent = current;

            if (irIzquierda(nombre.toLowerCase(), current.palabra.getNombre().toLowerCase())) {
                isLeftChild = true;
                current = current.hijoIzquierdo;
            } else {
                isLeftChild = false;
                current = current.hijoDerecho;
            }
            if (current == null) {
                return false;
            }
        } // Se obtiene el nodo a eliminar

        // Si no tiene hijos, se borra el nodo
        if (current.hijoIzquierdo == null && current.hijoDerecho == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.hijoIzquierdo = null;
            } else {
                parent.hijoDerecho = null;
            }

        } else if (current.hijoDerecho == null) {
            if (current == root) {
                root = current.hijoIzquierdo;
            } else if (isLeftChild) {
                parent.hijoIzquierdo = current.hijoIzquierdo;
            } else {
                parent.hijoDerecho = current.hijoIzquierdo;
            }

            // Si no tiene hijo izquierdo, se reemplaza por el subarbol derecho
        } else if (current.hijoIzquierdo == null) {
            if (current == root) {
                root = current.hijoDerecho;
            } else if (isLeftChild) {
                parent.hijoIzquierdo = current.hijoDerecho;
            } else {
                parent.hijoDerecho = current.hijoDerecho;
            }
        } else {
            Node successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.hijoIzquierdo = successor;
            } else {
                parent.hijoDerecho = successor;
            }
            successor.hijoIzquierdo = current.hijoIzquierdo;
        }
        return true; // exito al eliminar
    } // Fin eliminar()

    // Devuelve el nodo sucesor
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.hijoDerecho;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.hijoIzquierdo;
        }

        if (successor != delNode.hijoDerecho) {

            successorParent.hijoIzquierdo = successor.hijoDerecho;

            successor.hijoDerecho = delNode.hijoDerecho;
        }
        return successor;
    } // Fin getSuccessor()

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.hijoIzquierdo);
        node.getPalabra().mostrarPalabra();
        inOrder(node.hijoDerecho);
    } // Fin inOrder()

    public void ordenar() {
        inOrder(root);
    } // Fin ordenar()

    // Compara el orden de las palabras
    public static boolean irIzquierda(String nombreNuevo, String nombreActual) {
        boolean irIzquierda = false;

        // abecedario
        char[] abc = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z'};

        // contador y largo del titulo mas pequeño (limite)
        int cont = 0, limite = 0;

        if (nombreNuevo.length() > nombreActual.length()) {
            limite = nombreActual.length();
        } else if (nombreActual.length() > nombreNuevo.length()) {
            limite = nombreNuevo.length();
        } else if (nombreNuevo.length() == nombreActual.length()) {
            limite = nombreNuevo.length();
        }

        while (cont < limite) {

            if (nombreNuevo.charAt(cont) == nombreActual.charAt(cont)) {
                if (cont == limite - 1 && nombreNuevo.length() > nombreActual.length()) {
                    irIzquierda = false;
                    break;

                } else if (cont == limite - 1 && nombreActual.length() > nombreNuevo.length()) {
                    irIzquierda = true;
                    break;
                }
                cont++;

            } else if (nombreNuevo.charAt(cont) != nombreActual.charAt(cont)) {
                int contNueva = 0, contActual = 0;
                char letraNueva = nombreNuevo.charAt(cont);
                char letraActual = nombreActual.charAt(cont);

                for (int i = 0; i < abc.length; i++) {
                    if (letraNueva == abc[i]) {
                        contNueva = i;

                    } else if (letraActual == abc[i]) {
                        contActual = i;
                    }
                }

                if (contNueva > contActual) {
                    irIzquierda = false;
                    break;

                } else if (contActual > contNueva) {
                    irIzquierda = true;
                    break;
                }
            }
        }
        return irIzquierda;
    } // Fin irIzquierda()

} // Fin Tree{}
