/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

/**
 *
 * @author Adolfo Castillo, Andrea Sanchez, Luciano Rojas
 */
public class ListaEnlazada {
    NodoLista cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void insertar(PatronADN patron) {
        NodoLista nuevo = new NodoLista(patron);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

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
