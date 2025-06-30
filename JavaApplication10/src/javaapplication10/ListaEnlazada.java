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
 * Lista enlazada simple para manejar colisiones en la tabla hash.
 */
public class ListaEnlazada {
    NodoLista cabeza;
    
    /**
     * Constructor de la lista enlazada.
     */
    public ListaEnlazada() {
        this.cabeza = null;
    }

    /**
     * Inserta un nuevo patrón en la lista.
     * @param patron PatronADN a insertar.
     */
    public void insertar(PatronADN patron) {
        NodoLista nuevo = new NodoLista(patron);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    /**
     * Busca un patrón en la lista.
     * @param tripleta Tripleta a buscar.
     * @return PatronADN encontrado o null si no existe.
     */
    public PatronADN buscar(String tripleta) {
        NodoLista actual = cabeza;
        while (actual != null) {
            if (actual.dato.tripleta.equals(tripleta)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null; // no encontrado
    }
}
