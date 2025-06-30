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
 * Nodo de la lista enlazada para manejar colisiones en la tabla hash.
 */
public class NodoLista {
    PatronADN dato;
    NodoLista siguiente;
    
    /**
     * Constructor del nodo de la lista.
     * @param dato PatronADN que contiene la tripleta y su información.
     */
    public NodoLista(PatronADN dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
