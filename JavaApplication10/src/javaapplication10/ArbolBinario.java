/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

/**
 *
 * @author Adolfo Castillo, Andrea Sanchez, Luciano Rojas
 */
public class ArbolBinario {
    NodoArbol raiz;

    public void insertar(PatronADN patron) {
        raiz = insertarRecursivo(raiz, patron);
    }

    private NodoArbol insertarRecursivo(NodoArbol actual, PatronADN patron) {
        if (actual == null) {
            return new NodoArbol(patron);
        }
        if (patron.frecuencia < actual.patron.frecuencia) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, patron);
        } else {
            actual.derecho = insertarRecursivo(actual.derecho, patron);
        }
        return actual;
    }

    public void inOrden() {
        inOrdenRecursivo(raiz);
    }

    private void inOrdenRecursivo(NodoArbol nodo) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.izquierdo);
            System.out.println("Tripleta: " + nodo.patron.tripleta + ", Frecuencia: " + nodo.patron.frecuencia);
            inOrdenRecursivo(nodo.derecho);
        }
    }
}
