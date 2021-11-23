
package newpackage;

import java.util.ArrayList;

public class tree {
        private Node root; //Primer nodo del arbol
    private ArrayList<Palabra> palabras; //lista para obtener los objetos del arbol

    //Constructor
    public tree() {
        root = null;
    }

    public Palabra find(String nombre) { // encontrar el nodo q tenga la palabra dada
        Node current = root;   // se define la ubicación actual en el primer nodo

        while (!current.palabra.getNombre().toLowerCase().equals(nombre.toLowerCase())) {

            if (irIzquierda(nombre.toLowerCase(), current.palabra.getNombre().toLowerCase())) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current.palabra;
    }  // end find()

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
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }

        }
    }//Fin agregar

    // Elimina el nodo que tenga la palabra dado por el usuario
    public boolean eliminar(String nombre) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (!current.palabra.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
            parent = current;

            if (irIzquierda(nombre.toLowerCase(), current.palabra.getNombre().toLowerCase())) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        } // Se obtiene el nodo a eliminar

        // si no tiene hijos, se borra el nodo
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }

        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }

            // si no tiene hijo izquierdo, se reemplaza por el subarbol derecho
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true; // exito al eliminar
    }//Fin eliminar

    // Devuelve el nodo sucesor
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {

            successorParent.leftChild = successor.rightChild;

            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.leftChild);
        node.getPalabra().mostrarPalabra();
        inOrder(node.rightChild);

    }

    public void ordenar() {
        inOrder(root);
    }

    // Compara el orden de las palabras
    public static boolean irIzquierda(String nombreNuevo, String nombreActual) {
        boolean irIzquierda = false;

        // abecedario
        char[] abc = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z'};

        int cont = 0, limite = 0; // contador y largo del titulo mas pequeño (limite)

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
    }

}//Fin Tree
