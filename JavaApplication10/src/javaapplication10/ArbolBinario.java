/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

/**
 *
 * @author Adolfo Castillo, Andrea Sanchez, Luciano Rojas
 */


/**
 * Árbol binario de búsqueda para ordenar tripletas por frecuencia.
 */
public class ArbolBinario {
    NodoArbol raiz;

    /**
     * Constructor del árbol binario de búsqueda.
     */
    public ArbolBinario() {
        this.raiz = null;
    }

    /**
     * Inserta un patrón en el árbol.
     * @param patron PatronADN a insertar.
     */
    public void insertar(PatronADN patron) {
        raiz = insertarRecursivo(raiz, patron);
    }

    /**
     * Inserta recursivamente en el árbol binario.
     * @param actual Nodo actual.
     * @param patron Patron a insertar.
     * @return Nodo actualizado.
     */
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

    /**
     * Muestra el recorrido inorden del árbol.
     */
    //public void inOrden() {
        //inOrdenRecursivo(raiz);
    //}

    /**
    * Método auxiliar recursivo que recorre el árbol en inorden.
    * 
    * @param nodo Nodo actual del recorrido.
    * @param resultado StringBuilder donde se va acumulando la salida ordenada.
    */
    private void inOrdenRecursivo(NodoArbol nodo, StringBuilder resultado) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.izquierdo, resultado);
            resultado.append("Tripleta: ").append(nodo.patron.tripleta)
                     .append(" - Frecuencia: ").append(nodo.patron.frecuencia)
                     .append("\n");
            inOrdenRecursivo(nodo.derecho, resultado);
        }
    }
    
    /**
    * Realiza un recorrido inorden del árbol binario y devuelve un String
    * con todas las tripletas almacenadas y sus frecuencias en orden ascendente.
    * 
    * Este método es útil para mostrar los patrones almacenados ordenados por frecuencia.
    * 
    * @return String con la representación inorden del árbol.
    */
    public String inOrdenComoTexto() {
        StringBuilder resultado = new StringBuilder();
        this.inOrdenRecursivo(raiz, resultado);
        return resultado.toString();
    }
}
