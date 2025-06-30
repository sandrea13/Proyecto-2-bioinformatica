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
 * Nodo que almacena la posición de una tripleta dentro de la secuencia principal.
 */
public class NodoUbicacion {
    int posicion;
    NodoUbicacion siguiente;

    /**
     * Constructor del nodo de ubicación.
     * @param posicion Posición de la tripleta.
     */
    public NodoUbicacion(int posicion) {
        this.posicion = posicion;
        this.siguiente = null;
    }
}
