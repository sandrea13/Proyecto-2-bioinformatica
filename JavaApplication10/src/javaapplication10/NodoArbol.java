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
 * Nodo del árbol binario de búsqueda.
 */
public class NodoArbol {
    PatronADN patron;
    NodoArbol izquierdo, derecho;
    
    /**
     * Constructor del nodo.
     * @param patron PatronADN a almacenar en el nodo.
     */
    public NodoArbol(PatronADN patron) {
        this.patron = patron;
        this.izquierdo = null;
        this.derecho = null;
    }
}
