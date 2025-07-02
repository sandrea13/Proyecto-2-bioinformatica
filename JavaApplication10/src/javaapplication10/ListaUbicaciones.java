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
* Lista enlazada que almacena todas las ubicaciones donde aparece una tripleta.
*/
public class ListaUbicaciones {
    NodoUbicacion cabeza;

    
    /**
     * Constructor de la lista de ubicaciones.
     */
    public ListaUbicaciones() {
        this.cabeza = null;
    }

    /**
     * Agrega una nueva ubicación a la lista.
     * @param posicion Posición donde aparece la tripleta.
     */
    public void agregar(int posicion) {
        NodoUbicacion nuevo = new NodoUbicacion(posicion);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    /**
     * Imprime las ubicaciones donde aparece la tripleta.
     */
    public void imprimirUbicaciones() {
        NodoUbicacion actual = cabeza;
        while (actual != null) {
            System.out.print(actual.posicion + " ");
            actual = actual.siguiente;
        }
    }
    
    public String obtenerUbicacionesComoTexto() {
        StringBuilder sb = new StringBuilder();
        NodoUbicacion actual = cabeza;
        while (actual != null) {
            sb.append(actual.posicion).append(" ");
            actual = actual.siguiente;
        }
        return sb.toString();
    }
}
