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
 * Clase que implementa una tabla hash con manejo de colisiones por encadenamiento.
 */
public class HashTable {
    private ListaEnlazada[] tabla;
    private int tamaño;

    /**
     * Constructor de la tabla hash.
     * @param tamaño Tamaño de la tabla.
     */
    public HashTable(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new ListaEnlazada[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new ListaEnlazada();
        }
    }

    public ListaEnlazada[] getTabla() {
        return tabla;
    }

    public void setTabla(ListaEnlazada[] tabla) {
        this.tabla = tabla;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    

    /**
     * Calcula el índice hash para una tripleta.
     * @param tripleta Tripleta de nucleótidos.
     * @return Índice calculado.
     */
    private int funcionHash(String tripleta) {
        int hash = 0;
        for (int i = 0; i < tripleta.length(); i++) {
            hash += tripleta.charAt(i) * (i + 1);
        }
        return hash % tamaño;
    }

    
    /**
     * Inserta una tripleta en la tabla hash.
     * @param tripleta Tripleta a insertar.
     * @param posicion Posición en la secuencia principal.
     */
    public void insertar(String tripleta, int posicion) {
        int indice = funcionHash(tripleta);
        PatronADN patron = tabla[indice].buscar(tripleta);
        if (patron == null) {
            patron = new PatronADN(tripleta);
            patron.agregarUbicacion(posicion);
            tabla[indice].insertar(patron);
        } else {
            patron.frecuencia++;
            patron.agregarUbicacion(posicion);
        }
    }

    /**
     * Busca una tripleta en la tabla hash.
     * @param tripleta Tripleta a buscar.
     * @return PatronADN encontrado o null si no existe.
     */
    public PatronADN buscar(String tripleta) {
        int indice = funcionHash(tripleta);
        return tabla[indice].buscar(tripleta);
    }
    
    
    public void imprimirTabla() {
        for (int i = 0; i < tabla.length; i++) {
            NodoLista actual = tabla[i].cabeza;
            while (actual != null) {
                System.out.println("Tripleta: " + actual.dato.tripleta + 
                                   " | Frecuencia: " + actual.dato.frecuencia);
                actual = actual.siguiente;
            }
        }
    }
    
    public PatronADN obtenerPatronMasFrecuente() {
        PatronADN masFrecuente = null;

        for (int i = 0; i < tabla.length; i++) {
            NodoLista actual = tabla[i].cabeza;
            while (actual != null) {
                if (masFrecuente == null || actual.dato.frecuencia > masFrecuente.frecuencia) {
                    masFrecuente = actual.dato;
                }
                actual = actual.siguiente;
            }
        }

        return masFrecuente;
    }
    
    public PatronADN obtenerPatronMenosFrecuente() {
        PatronADN menosFrecuente = null;

        for (int i = 0; i < tabla.length; i++) {
            NodoLista actual = tabla[i].cabeza;
            while (actual != null) {
                if (menosFrecuente == null || actual.dato.frecuencia < menosFrecuente.frecuencia) {
                    menosFrecuente = actual.dato;
                }
                actual = actual.siguiente;
            }
        }

        return menosFrecuente;
    }
    
    public String reporteColisiones() {
        String reporte = "";
        boolean hayColisiones = false;

        for (int i = 0; i < tabla.length; i++) {
            NodoLista actual = tabla[i].cabeza;

            // Contar cuántos nodos hay en esta posición
            int contador = 0;
            NodoLista temp = actual;
            while (temp != null) {
                contador++;
                temp = temp.siguiente;
            }

            // Si hay más de un nodo, hubo colisión
            if (contador > 1) {
                hayColisiones = true;
                reporte+=("Colisión en índice ") + i+ (":\n");

                while (actual != null) {
                    reporte+=(" - Tripleta: ")+(actual.dato.tripleta)+(" | Frecuencia: ")+(actual.dato.frecuencia)+("\n");
                    actual = actual.siguiente;
                }
                reporte+=("\n");
            }
        }

        if (!hayColisiones) {
            reporte+=("No se detectaron colisiones.\n");
        }

        return reporte.toString();
    }


}
