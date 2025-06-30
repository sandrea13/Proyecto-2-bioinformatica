/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

/**
 *
 * @author Adolfo Castillo, Andrea Sanchez, Luciano Rojas
 */
public class ListaUbicaciones {
    NodoUbicacion cabeza;

    public ListaUbicaciones() {
        this.cabeza = null;
    }

    public void agregar(int posicion) {
        NodoUbicacion nuevo = new NodoUbicacion(posicion);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public void imprimirUbicaciones() {
        NodoUbicacion actual = cabeza;
        while (actual != null) {
            System.out.print(actual.posicion + " ");
            actual = actual.siguiente;
        }
    }
}
